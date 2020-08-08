package org.bheaver.ngl4.base.context

case class ExecutionContext(libCode: String, requestId: String, dbName: String, jwtToken: String)
