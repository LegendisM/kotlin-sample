package org.example.common

/*
* The Delegation pattern has proven to be a good alternative to implementation inheritance, and Kotlin supports it natively requiring zero boilerplate code.
* A class Derived can implement an interface Base by delegating all of its public members to a specified object
* */

interface Basic {
    fun print()
    fun secondPrint()
}

class MainImplement : Basic {
    override fun print() {
        println("First Print Worked")
    }

    override fun secondPrint() {
        println("Second Print Worked")
    }
}

class MyDerived(base: Basic) :
    Basic by base { // NOTE: use a implement version of Basic, instead of implement again methods in MyDerived class
    override fun secondPrint() { // override a default delegated member of implemented class
        println("Override Second Print Worked")
    }
}

private fun main() {
    val baseImp = MainImplement()
    val dr = MyDerived(baseImp)
    dr.print()
    dr.secondPrint()
}