package org.example.common

private fun main() {
    // * Apply : change a property of instance
    ProHuman("Hamid", "Adam", 1).apply {
        level = 100
        color = Color.BLUE // use this is optional
        this.color = Color.BLUE
    }

    // * Also : additional info (like print a property or instance value)
    ProHuman("Hamid", "Adam", 1).also {
        println(it.firstName)
        println(it)
    }

    // * Let : call some functions and return a new value as output of let
    val numbers = mutableListOf(1, 2, 3, 4, 5)

    // Without Scope
    val result = numbers.map { it * 2 }.filter { it > 5 }
    println(result)
    // With Scope
    val sumResult = numbers.map { it * 2 }.filter { it > 5 }.let {
        println(it) // print final ready result of operations
        it.sum() // sum the list items and return that result value
    }
    println(sumResult)

    // Let : Example 2
    val name: String? = "Hello";

    val result2 = name?.let {// check the name null state to run (prevent null exception)
        println(name.length)
        it.uppercase()
    }

    println(result2)

    // * Run : object initialization and computation of the return value
    val name2 = "Reza"
    val runResult = run {
        val name = "Hamid"
        println("Run without context $name")
        name
    }

    val nameResult = name2.run {
        println("$name2 $runResult")
        "$name2 $runResult"
    }

    println(nameResult)
}