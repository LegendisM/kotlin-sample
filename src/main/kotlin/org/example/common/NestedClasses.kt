package org.example.common

class Outer {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

val demo = Outer().Inner().foo() // == 1

interface OuterInterface {
    class InnerClass
    interface InnerInterface
}

class OuterClass {
    class InnerClass
    interface InnerInterface
}