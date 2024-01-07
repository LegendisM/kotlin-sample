package org.example.common

import kotlin.properties.Delegates
import kotlin.reflect.KProperty

/*
* Delegation Properties
* With some common kinds of properties, even though you can implement them manually every time you need them,
* it is more helpful to implement them once, add them to a library, and reuse them later.
*
* Lazy properties: the value is computed only on first access.

* Observable properties: listeners are notified about changes to this property.

* Storing properties in a map instead of a separate field for each property.
*
* */

// * Self-Made Delegate - after this section we use kotlin default and standard delegates like -> lazy, Delegates.observable, ...

class Delegate {
    operator fun getValue(thisRef: Any?, property: KProperty<*>): String {
        return "$thisRef, thank you for delegating '${property.name}' to me!"
    }

    operator fun setValue(thisRef: Any?, property: KProperty<*>, value: String) {
        println("$value has been assigned to '${property.name}' in $thisRef.")
    }
}

class DelegateExample {
    var username: String by Delegate()
    var password: String = "empty";
}

private fun testA() {
    val example = DelegateExample()
    example.username = "Hamid";
    example.password = "1234"
}

/* Lazy Delegate
* lazy() is a function that takes a lambda and returns an instance of Lazy<T>,
* which can serve as a delegate for implementing a lazy property.
* The first call to get() executes the lambda passed to lazy() and remembers the result. Subsequent calls to get() simply return the remembered result.
* */
val lazyValue: String by lazy {
    println("computed")
    "Final Value"
}

private fun testB() {
    println(lazyValue)
    println(lazyValue)
}

/*
* Observable Delegate (called after new values assigned)
* Delegates.observable() takes two arguments: the initial value and a handler for modifications.
* The handler is called every time you assign to the property (after the assignment has been performed).
* It has three parameters: the property being assigned to, the old value, and the new value
* */

var observableValue: String by Delegates.observable("A") { property, oldValue, newValue ->
    println("$oldValue -> $newValue")
}

class UserObservable(val defaultUsername: String) {
    var username: String by Delegates.observable(defaultUsername) { property, oldValue, newValue ->
        println("[UserObservable]: $oldValue to $newValue")
    }
}

// * Vetoable (called before new value assigned - and we can accept/reject new value with true/false)
var vetoableValue: String by Delegates.vetoable("HI") { property, oldValue, newValue ->
    newValue != "Hello" // if new value != Hello -> set the new value , else return false and cancel set process
}

private fun testC() {
    // Observable
    observableValue = "B";
    val obsUser = UserObservable("Hamid")
    obsUser.username = "Reza"
    // * Vetoable
    println(vetoableValue)
    vetoableValue = "Hello"
    println(vetoableValue)
    vetoableValue = "Bye"
    println(vetoableValue)
}

/*
* Delegating to another property
* A property can delegate its getter and setter to another property. Such delegation is available for both top-level and class properties (member and extension).
* To delegate a property to another property, use the :: qualifier in the delegate name, for example, this::delegate or MyClass::delegate.
* */
var topLevelInt: Int = 0
var delegatedToTopLevelIt = ::topLevelInt;

class ClassWithDelegate(val anotherClassInt: Int)

class MyClass(var memberInt: Int, val anotherClassInstance: ClassWithDelegate) {
    var delegatedToMember: Int by this::memberInt
    var delegatedToTopLevel: Int by ::topLevelInt

    val delegatedToAnotherClass: Int by anotherClassInstance::anotherClassInt
}

var MyClass.extDelegated: Int by ::topLevelInt

private fun testD() {
    println("$topLevelInt ${delegatedToTopLevelIt.get()}")
    delegatedToTopLevelIt.set(10);
    println("$topLevelInt ${delegatedToTopLevelIt.get()}")
    topLevelInt = 5;
    println("$topLevelInt ${delegatedToTopLevelIt.get()}")
}

/*
* Storing properties in a map
* One common use case is storing the values of properties in a map.
* This comes up often in applications for things like parsing JSON or performing other dynamic tasks.
* In this case, you can use the map instance itself as the delegate for a delegated property
* */
class User(val map: Map<String, Any?>) {
    val name: String by map
    val age: Int by map
}

class MutableUser(val map: MutableMap<String, Any?>) {
    var name: String by map
    var age: Int by map
}

private fun testE() {
    val user = User(
        mapOf(
            "name" to "John Doe",
            "age" to 25
        )
    )
    val mutableUser = MutableUser(
        mutableMapOf(
            "name" to "Hamid",
            "age" to 29
        )
    )
}