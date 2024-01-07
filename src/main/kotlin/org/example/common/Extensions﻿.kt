package org.example.common

import org.example.hello.Hello

// * To declare an extension function, prefix its name with a receiver type, which refers to the type being extended. The following adds a swap function to MutableList<Int>:
fun MutableList<Int>.swap(index: Int, index2: Int) {
    println("a custom created extension function for a class - list size -> ${this.size}")
}

fun Hello.myExtensionName(text: String) {
    this.bye()
    println("im a custom extension $text")
}

var Hello.myCustomProperty: Int
    get() = 10
    set(value) {
        value + 10
    }

fun Any?.toString(): String {
    if (this == null) return "null"
    // After the null check, 'this' is autocast to a non-nullable type, so the toString() below
    // resolves to the member function of the Any class
    return toString()
}

val <T> List<T>.lastIndex: Int
    get() = size - 1

class MyCompClass {
    companion object { }  // will be called "Companion"
}

fun MyCompClass.Companion.printCompanion() { println("companion") }

private fun test(){
    MyCompClass.Companion.printCompanion();
}