package org.example.common

/*
* Type aliases provide alternative names for existing types.
* If the type name is too long you can introduce a different shorter name and use the new one instead.
* */

typealias StringSet = Set<String>

typealias CustomList<T> = List<T>

// * Function Types
typealias MyHandler = (Int, String) -> Unit
typealias Predicate<T> = (T) -> Boolean


// * Inner And Nested Classes Types
class A {
    inner class Inner
}

typealias AInner = A.Inner

private fun main() {
    val f: Predicate<Int> = { i: Int -> i == 1 }
    val myHandler: MyHandler = { i, s -> println("$i $s") }

    f(1)
    myHandler(255, "Hello")
}