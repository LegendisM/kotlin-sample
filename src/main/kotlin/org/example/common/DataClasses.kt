package org.example.common

/*
    Data classes
    in Kotlin are primarily used to hold data.
    For each data class, the compiler automatically generates additional member functions that allow you to print an instance
    to readable output, compare instances, copy instances, and more.
    Data classes are marked with data
    -> The compiler automatically derives the following members from all properties declared in the primary constructor:

    .equals()/.hashCode() pair

    .toString() of the form "User(name=John, age=42)"

    .componentN() functions corresponding to the properties in their order of declaration.

    .copy() function (see below).
* */

data class Account(val username: String, val password: String, var age: Int = 18) {
    var customFieldInsideOnly: String = "custom";
}

private fun test() {
    val accountOne = Account("A", "B", 20)
    val accountTwo = accountOne.copy()

    // * Data classes and destructuring declarations
    val (username, password, age) = accountOne;
    println("$username, $age years of age")
}