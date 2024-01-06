package org.example.common

class Box<T>(value: T) {
    var custom = value;
}

interface Collection<E> {
    fun addAll(items: List<E>);
}

fun <T, G> singletonList(items: List<T>, test: G): List<T> {
    return items;
}

private fun test() {
    val box: Box<Int> = Box<Int>(1)
    val box2: Box<String> = Box<String>("Test")
}