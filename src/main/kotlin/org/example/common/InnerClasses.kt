package org.example.common

/*
* A nested class marked as inner can access the members of its outer class. Inner classes carry a reference to an object of an outer class:
* you can don't mark the inner class as inner but in this case you don't access on the properties of the inner class
* */

class AccessibleOuter {
    private val bar: Int = 1

    inner class Inner {
        fun foo() = bar
    }
}

class NoAccessibleOuter {
    private val bar: Int = 1

    class Inner {
        fun foo() = bar
    }

    fun test(){
        Inner().foo()
    }
}

private fun test() {
    AccessibleOuter().Inner().foo()
    // NoAccessibleOuter().Inner()  # we have exception in this line because we don't have access on Inner of NoAccessibleOuter
}