package org.bheaver.ngl4.base.util.db

import org.bson.BsonType
import org.mongodb.scala.bson.BsonValue

object DocumentUtils {
  implicit def docToString(bsonValue: BsonValue): String = Option(bsonValue)
    .map(bsonValue =>
    bsonValue.getBsonType match {
      case BsonType.STRING => bsonValue.asString().getValue
      case BsonType.INT64 => bsonValue.asInt64().getValue.toString
      case BsonType.INT32 => bsonValue.asInt32().getValue.toString
      case _ => ""
    }
  ).getOrElse("")
}
