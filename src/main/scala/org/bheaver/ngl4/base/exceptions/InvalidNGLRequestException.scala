package org.bheaver.ngl4.base.exceptions

class InvalidNGLRequestException(message: String) extends RuntimeException(message: String) {

}
object InvalidNGLRequestException {
  val MALFORMED_HEADER: String = "Malformed header"
}