package org.bheaver.ngl4.base.converters

import java.util.concurrent.CompletionStage

import scala.concurrent.Future
import scala.compat.java8.FutureConverters._

object FutureHelpers {
  implicit class ScalaFutureToCompletableFuture[A](scalaFuture: Future[A]){
    def toWebServerResponse(): CompletionStage[A] = scalaFuture.toJava
  }
}
