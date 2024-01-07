package org.example.common

/*
* Sealed -> Sealed classes and interfaces represent restricted class hierarchies that provide more control over inheritance.
* The same works for sealed interfaces and their implementations: once a module with a sealed interface is compiled, no new implementations can appear.
* In some sense, sealed classes are similar to enum classes: the set of values for an enum type is also restricted,
* but each enum constant exists only as a single instance, whereas a subclass of a sealed class can have multiple instances, each with its own state.
* To declare a sealed class or interface, put the sealed modifier before its name
* A sealed class is abstract by itself, it cannot be instantiated directly and can have abstract members.
* */

/*
* Example :
* consider a library's API. It's likely to contain error classes to let the library users handle errors that it can throw.
* If the hierarchy of such error classes includes interfaces or abstract classes visible in the public API,
* then nothing prevents implementing or extending them in the client code.
* However, the library doesn't know about errors declared outside it, so it can't treat them consistently with its own classes.
* With a sealed hierarchy of error classes, library authors can be sure that they know all possible error types and no other ones can appear later.
* */

// * Example 1

sealed class Result {
    data class Success(val data: String) : Result()
    data class Error(val message: String) : Result()
}

sealed class ApiError {
    data class UnauthorizedError(val message: String) : ApiError()
    data class ForbiddenError(val message: String, val statusCode: Int) : ApiError()
}

// * Example 2
sealed interface Error

sealed class IOError(): Error

class FileReadError(val file: Any): IOError()
class DatabaseError(val source: Any): IOError()

object RuntimeError : Error

// * Example 3

sealed class Animal {
    abstract fun makeSound()
}

object Dog : Animal() {
    override fun makeSound() {
        println("Woof!")
    }
}

object Cat : Animal() {
    override fun makeSound() {
        println("Meow!")
    }
}

object AnimalFactory {
    fun createAnimal(type: String): Animal? {
        return when (type) {
            "dog" -> Dog
            "cat" -> Cat
            else -> null
        }
    }
}