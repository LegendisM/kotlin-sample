package org.example.common

data class UserResponse(
    val message: String
)

data class ResponseDTO(
    val data: Any,
    val status: String
)

class UserService {
    fun getUser(): UserResponse {
        return UserResponse("hello")
    }
}

// * Default
fun Long.add(number: Long): Long {
    return this + number
}

fun UserResponse.result(status: String): ResponseDTO {
    return ResponseDTO(
        data = this.message,
        status = status
    )
}

// * Infix
infix fun Long.sum(number: Long): Long {
    return this + number
}

infix fun UserResponse.resultV2(status: String): ResponseDTO {
    return ResponseDTO(
        data = this.message,
        status = status
    )
}

fun main() {
    // * before
    val number1: Long = 1L
    val result1 = number1.add(10)

    // * after
    val number2: Long = 1L
    val result2 = number2 sum 10

    // * before
    val userResponse1 = UserResponse(message = "Hello")
    val dto1 = userResponse1.result("MyCustomStatus")

    // * after
    val userResponse2 = UserResponse(message = "Hello")
    val dto2 = userResponse2 resultV2 "MyCustomStatus"
}
