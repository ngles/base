package org.bheaver.ngl4.base.exceptions

import org.bheaver.ngl4.base.constants.ExceptionMessage
import ExceptionMessage._

class NGLException(message: String) extends RuntimeException(message: String){
  def this(exceptionMessage: ExceptionMessage) = this(exceptionMessage.toString)
}
class InvalidNGLRequestException(exceptionMessage: ExceptionMessage) extends NGLException(exceptionMessage: ExceptionMessage.Value) {
  def this() = this(BAD_REQUEST)
}
object InvalidNGLRequestException {
  val MALFORMED_HEADER: String = "Malformed header"
}