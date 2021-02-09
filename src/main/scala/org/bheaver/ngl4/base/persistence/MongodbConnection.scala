package org.bheaver.ngl4.base.persistence

import org.mongodb.scala.{MongoClient, MongoDatabase}
import org.bheaver.ngl4.base.model.LibCode
import org.mongodb.scala.model.Filters
import org.bheaver.ngl4.base.util.db.DocumentUtils._

import scala.concurrent.Future

object MongodbConnection {
  val MASTER_DATABASE:String = "master_config"

  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  implicit class MongoDatabaseConnector(database: String) {
    def getDatabase(): MongoDatabase = mongoClient.getDatabase(database)
  }

  implicit class MongoDatabaseConnectorLibCode (libCode: LibCode) {
    def fillLibCode(): Future[Option[LibCode]] = MASTER_DATABASE.getDatabase()
      .getCollection("library_info")
      .find(Filters.eq("libcode", libCode.libCode))
      .map(doc => {
        libCode.copy(dB = doc("database"), libName = doc("libraryName"))
      }).headOption()

    def getDatabase(): MongoDatabase = libCode.dB.getDatabase()
  }
}
