package org.example.common

/*
* Object expressions create objects of anonymous classes, that is, classes that aren't explicitly declared with the class declaration.
* Such classes are useful for one-time use.
* You can define them from scratch, inherit from existing classes, or implement interfaces.
* Instances of anonymous classes are also called anonymous objects because they are defined by an expression, not a name.
* If you just need an object that doesn't have any nontrivial supertypes, write its members in curly braces after object
* */

open class PrinterManager(val printerName: String)

interface Printer {
    fun printMessage(message: String);
}

val myVariableObject: PrinterManager = object : PrinterManager("Printer-1"), Printer {
    val hello = "Hi"

    override fun printMessage(message: String) {
        println(message)
    }

    override fun toString(): String {
        return "Custom Value of Object"
    }
}

object MyObject {
    val hello = "Hi"
    var message = "How are you?"

    fun say(message: String) {
        this.message = message;
        println(this.message)
    }

    // we can override and we can extend everythings
    override fun toString(): String {
        return super.toString()
    }
}

object PrinterFactory : Printer {
    override fun printMessage(message: String) {
        println("[PRINTER]: $message")
    }
}

// * Using anonymous objects as return and value types
class C {
    private fun getObject() = object {
        val x: String = "x"
    }

    fun printX() {
        println(getObject().x)
    }
}

/*
* Object Declaration
* it always has a name following the object keyword.
* just like a variable declaration, an object declaration is not an expression, and it cannot be used on the right-hand side of an assignment statement.
* */

// * The Singleton pattern can be useful in several cases, and Kotlin makes it easy to declare singletons:
object DataProviderManager {
    fun registerDataProvider(provider: String) {
        // ...
    }

    val allDataProviders: String
        get() = "Provider"
}

// * Data Object
data object MyDataObject {
    val x: Int = 3
}

// * Sealed with object
sealed interface ReadResult
data class Number(val number: Int) : ReadResult
data class Text(val text: String) : ReadResult
data object EndOfFile : ReadResult

fun printReadResult(r: ReadResult) {
    when(r) {
        is Number -> println("Num(${r.number})")
        is Text -> println("Txt(${r.text})")
        is EndOfFile -> println("EOF")
    }
}


private fun main() {
    println(myVariableObject)
    MyObject.say("Hello")
    PrinterFactory.printMessage("Bye")
    DataProviderManager.registerDataProvider("A Provider Data Class")
    println(MyDataObject.toString())
    printReadResult(EndOfFile)
    printReadResult(Number(1234))
}