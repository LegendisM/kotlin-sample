package org.example.common

fun find(username: String, email: String = "default@value.com"): Boolean {
    return listOf("Hamid", "Reza", "Ali").indexOf(username) != -1
}

fun inlineFind(username: String, optionField: String? = null): Boolean = listOf("Hamid", "Reza").indexOf(username) != -1

val imLambda = { a: Int, b: String -> println("Lambda Result is $a $b") }

val imNonArgumentLambda = {
    10 / 2
}

val calculatorLambda = { numberOne: Int, numberTwo: Int ->
    val result = numberOne + numberTwo
    "Result is ${result}"
}

val imLambdaWithTypeDefinition: (numberOne: Int, numberTwo: Int) -> Int = { numberOne, numberTwo ->
    numberOne + numberTwo
}

fun calculator(a: Int, b: Int, op: (a: Int, b: Int) -> Int): Int {
    return op(a, b)
}

private fun main() {
    println(find("Ali"))
    println(find(username = "Ali"))
    println(inlineFind("Ali"))
    println(inlineFind(username = "Ali"))

    imLambda(1, "Hello")

    println(imNonArgumentLambda())
    println(calculatorLambda(5, 10))

    val calculateResultOne = calculator(2, 8) { a, b -> a * b }
    val calculateResultTwo = calculator(12, 2) { a, b -> a / b }
    println(calculateResultOne)
    println(calculateResultTwo)
}