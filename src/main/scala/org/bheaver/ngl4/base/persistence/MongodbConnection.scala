package org.bheaver.ngl4.base.persistence

import org.mongodb.scala.{MongoClient, MongoDatabase}

object MongodbConnection {
  val MASTER_DATABASE:String = "master_config"

  val mongoClient: MongoClient = MongoClient("mongodb://localhost:27017")

  implicit class MongoDatabaseConnector(database: String) {
    def getDatabase(): MongoDatabase = mongoClient.getDatabase(database)
  }
}
