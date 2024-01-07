package org.example.common

/*
* Inline Value Class
* it is useful to wrap a value in a class to create a more domain-specific type.
* Inline classes are a subset of value-based classes.
* They don't have an identity and can only hold values.
* */

@JvmInline
value class Username(val username: String)

interface Printable {
    fun sayMyName()
}

@JvmInline
value class Name(val name: String) : Printable {
    override fun sayMyName() {
        println(this.name)
    }
}

private fun test() {
    val username = Username("MyUsername")
    val name = Name("Heisenberg")
    name.sayMyName()
}