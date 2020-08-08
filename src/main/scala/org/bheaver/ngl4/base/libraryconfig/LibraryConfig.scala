package org.bheaver.ngl4.base.libraryconfig

import scala.collection.mutable
import org.bheaver.ngl4.base.persistence.MongodbConnection._

import org.mongodb.scala.model.Filters._
import org.bheaver.ngl4.base.util.Helpers._

object LibraryConfig {
  val libraryMap: mutable.Map[String, String] = mutable.Map.empty

  def getLibraryDatabase(libCode: String): String =
    Option(libraryMap(libCode)) match {

      case Some(value) => value

      case None => {
        val databaseName = MASTER_DATABASE.getDatabase()
          .getCollection("library_info")
          .find(equal("libcode", libCode))
          .headResult()
          .getString("database")

        libraryMap += (libCode -> databaseName)

        libraryMap(libCode)
      }
    }
}