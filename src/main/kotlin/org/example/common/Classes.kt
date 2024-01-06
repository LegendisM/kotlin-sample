package org.example.common

class MyNameIsEmpty

/*
* Constructor
* A class in Kotlin has a primary constructor and possibly one or more secondary constructors.
* The primary constructor is declared in the class header, and it goes after the class name and optional type parameters.
* The class header can't contain any runnable code. If you want to run some code during object creation, use initializer blocks inside the class body -> init keyword
* */
class Person constructor(firstName: String) {
    val words: MutableList<String> = mutableListOf()
}

class MetaPerson(firstName: String) {}

class Human(firstName: String) {
    val firstProperty = "FirstProperty $firstName"

    init {
        println("First initializer block that prints ($firstName)")
    }

    val secondProperty = "SecondProperty $firstProperty"

    init {
        println("Second initializer block that prints ($secondProperty)")
    }
}

class ProHuman(
    val firstName: String,
    val lastName: String,
    var level: Int,
    var color: Color = Color.BLUE,
    var isEmployed: Boolean = false,
) {
    val myFirstName = firstName;
    val myColor = color;

    init {
        // * you can't change variables are marked with val (non-mutable)
        // -> firstName = "";
        // * change level because it's marked as var (mutable)
        level++
        color = Color.GREEN
    }
}

// * If the constructor has annotations or visibility modifiers, the constructor keyword is required and the modifiers go before it:
// -> class Customer public @Inject constructor() {}

// * Secondary Constructor
class FakeHuman {
    init {
        println("Init block (1)")
    }

    constructor(name: String) {
        println("Constructor $name (2)")
    }
}

// * If the class has a primary constructor, each secondary constructor needs to delegate to the primary constructor
class MetaHuman(fullName: String) {
    constructor(name: String, age: Int) : this(name) {
        println("$name $age")
    }
}

//* Private Constructor
class DontCreateMe private constructor() { /*...*/ }

// * Create Instance
val person = Person("Hamid")
val human = Human("Reza")
val metaHuman = MetaHuman("Mohammad")
val metaHumanV2 = MetaHuman("HamidReza", 18)

/*
* Inheritance
* By default, Kotlin classes are final – they can't be inherited. To make a class inheritable, mark it with the open keyword:
* use open keyword before the class to apply inheritable option to class
* */
open class Base(foodName: String) {
    val propertyOne = "Hello"
    open val propertyTwo = "Bye"

    constructor(foodName: String, foodLevel: Int) : this(foodName) {}

    fun eat() {
        println("default definition - can't override")
    }

    open fun drink() {
        println("you can override this method")
    }
}

class Derived(foodName: String) : Base(foodName) {}

class DerivedPro : Base {
    override val propertyTwo: String = "Hello Guys";

    constructor(foodName: String) : super(foodName) {}
    constructor(secondFoodName: String, level: Int) : super(secondFoodName, level) {}

    override fun drink() {
        println("im DerivedPro and i override that ${super.propertyOne}")
        super.drink() // & call default definition if you want
    }
}

// * Multi Inheritance
open class RectangleExample {
    open fun draw() { /* ... */
    }
}

interface PolygonExample {
    fun draw() { /* ... */
    } // interface members are 'open' by default
}

class Square() : RectangleExample(), PolygonExample {
    // The compiler requires draw() to be overridden:
    override fun draw() {
        super<RectangleExample>.draw() // call to Rectangle.draw()
        super<PolygonExample>.draw() // call to Polygon.draw()
    }
}

/*
* Abstract class
* A class may be declared abstract, along with some or all of its members. An abstract member does not have an implementation in its class.
* You don't need to annotate abstract classes or functions with open.
* */
abstract class Polygon {
    abstract fun draw()
}

class Rectangle : Polygon() {
    override fun draw() {
        TODO("Not yet implemented")
    }
}

// * You can override a non-abstract open member with an abstract one.
open class OpenPolygon {
    open fun draw() {
        // some default polygon drawing method
    }
}

abstract class WildShape : OpenPolygon() {
    // Classes that inherit WildShape need to provide their own
    // draw method instead of using the default on Polygon
    abstract override fun draw()
}

// * Class Properties
class Address {
    val field: String = "non-mutable"
    var name: String = "Holmes, Sherlock"
    var street: String = "Baker"
    var city: String = "London"
    var state: String? = null
    var zip: String = "123456"
}

// * Getters and setters
class ShapeController {
    var area: Float = 1f
        get() {
            return this.area * 2
        }
        set(value) {
            field = value / 2
        }
    val isEmpty: Boolean
        get() = this.area == 0f
    var setterVisibility: String = "abc"
        private set // the setter is private and has the default implementation
}

// * Late-initialized properties and variables
public class MyTest {
    private lateinit var subject: String

    fun setup() {
        subject = "value"
    }
}

