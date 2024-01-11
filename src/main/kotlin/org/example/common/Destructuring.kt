package org.example.common

data class CustomResult(var statusCode: Int, val statusMessage: String)

private fun main() {
    val result = CustomResult(statusCode = 1234, statusMessage = "Hello")
    val (statusCode, statusMessage) = result
    println("$statusCode $statusMessage")

    val (second, first) = Pair<String, String>("First", "Second")
    println("$first $second")
}