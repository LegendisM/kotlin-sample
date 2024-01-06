package org.example.core

import org.example.common.API_ENDPOINT_URL
import org.example.common.Color
import org.example.common.myExtensionName
import org.example.other.Helper
import org.example.hello.Hello as HelloBabe

@OptIn(ExperimentalStdlibApi::class)
fun main(args: Array<String>) {
    // One-line comment

    /*
    * Multi-line comment
    * */

    // # Variables
    var mutableVariable = "Mutable Variable Value"
    val constantVariable = "Constant Variable Value"
    var mutableIntVariable: Int = 1
    var constantStringVariable: String = "Byte | Short | Int | Long | Float | Double | Boolean | Char | String"
    val multilineString: String = """
        Hello Im $mutableVariable, How are you ?
        Welcome, ${'$'}999.05
    """.trimIndent()
    val anyVariable: Any = "Any Type";

    println(multilineString)

    // # String formatting

    // * Formats to add zeroes and make a length of seven
    val integerNumber = String.format("%07d", 31416)
    println(integerNumber) // 0031416

    // * Formats with four decimals and sign
    val floatNumber = String.format("%+.4f", 3.141592)
    println(floatNumber) // +3.1416

    // * Formats with uppercase for two placeholders
    val helloString = String.format("%S %S", "hello", "world")
    println(helloString) // HELLO WORLD

    // # Type check
    if (anyVariable is String) {
        println("anyVariable is String")
    }

    if (anyVariable !is String) {
        println("anyVariable is not String")
    }

    // # Type cast (Safe)
    if (anyVariable is String && anyVariable.length == 8) {
        println("anyVariable is a String and the length of this string is ${anyVariable.length}")
    }

    // # Type cast (Unsafe)
    val newAnyVariable: String = anyVariable as String;
    // val newIntAnyVariable: Int = anyVariable as Int; // throw exception because isn't possible in runtime

    //# Type cast (Safe with nullable)
    val newIntAnyVariableFixed: Int? =
        anyVariable as? Int; // isn't possible but its give a null instead of throwing error (need to mark left-side as nullable with ?)

    // # Array
    val lettersArray = arrayOf("a", "b", "c")
    val nullArray = arrayOfNulls<String>(3)
    val emptyArray = emptyArray<Int>()
    val structuredArray = Array(5) { Array<String>(2) { index: Int -> index.toString() } }

    println(lettersArray)
    println(nullArray)
    println(emptyArray)
    println(structuredArray)

    // # Collections

    // * List -> Ordered collections of items (with duplicate items) (with index from zero to ...)
    val constantUniqueNames: List<String> = listOf("Hamid", "Reza", "Mohammad")
    var mutableUniqueNames: MutableList<String> = mutableListOf("Hamid", "Reza", "Mohammad");

    mutableUniqueNames.add(constantUniqueNames.first());
    mutableUniqueNames.removeIf { e -> e == constantUniqueNames[0] }
    println("Hamid" in mutableUniqueNames) // is value exists in list
    println(mutableUniqueNames.count())

    // * Set -> Unordered collections of unique items (no-duplicate-item)
    val systemRoles: Set<String> = setOf("Administrator", "Admin", "User");
    var userRoles: MutableSet<String> = mutableSetOf("Administrator", "User")

    userRoles.add("Administrator")
    println("Administrator" in systemRoles) // is value exists in list
    println(userRoles)

    // * Map -> store items as key-value pairs. You access the value by referencing the key
    val systemUsers: Map<String, Float> = mapOf(
        "Hamid" to 1.1f,
        "Reza" to 1.2f,
        "Mohammad" to 1.3f,
    )
    var customUsers: MutableMap<String, Float> = mutableMapOf(
        "Hamid" to 2.1f,
    )

    customUsers.remove(customUsers.keys.first())
    customUsers.put("Reza", 2.2f)
    customUsers["Mohammad"] = 2.3f
    println("$customUsers | count =>${customUsers.count()}")
    println("Reza" in customUsers.keys)
    println(2.1f in customUsers.values)

    // # Control Flow

    // * If-else
    val trueCondition = true;
    val falseCondition = true;

    if (trueCondition) {
        println("Yes")
    } else {
        println("No")
    }

    if (trueCondition || falseCondition) {
        println("Control-Flow If-OR")
    }

    if (trueCondition && falseCondition) {
        println("Control-flow If-And")
    }

    if (!trueCondition) {
        println("Control-flow If-Not")
    }

    if (falseCondition) {
        println("if")
    } else if (trueCondition) {
        println("else-if")
    } else {
        println("else")
    }

    val controlFlowResult = if (trueCondition) {
        "Hi"
    } else {
        "Bye"
    }

    // * Inline-condition
    val resultCondition = if (trueCondition == falseCondition) "Yes" else "No"
    println("Short If result : $resultCondition")

    // * When : conditional expression with multiple branches. (like 'switch' in other languages)
    // * Note : when can be used either as a statement or as an expression
    val clientRole: String = "Administrator"
    val clientRoleSummary: String
    val clientColor: Color = Color.GREEN;

    when (clientRole) {
        "Administrator" -> println("I am Administrator")
        "ProductOwner" -> println("I am ProductOwner")
        "User" -> println("I am User")
        else -> println("Role not found")
    }

    val clientRoleLevel: Int = when (clientRole) {
        "Administrator" -> 10
        "ProductOwner" -> 8
        "User" -> 1
        else -> -1
    }

    clientRoleSummary = when {
        clientRoleLevel == 10 -> "I am a Administrator"
        clientRoleLevel == 8 -> "I am a ProductOwner"
        clientRoleLevel <= 7 -> "I am a User"
        else -> "I am a non-client"
    }

    when (clientColor) {
        Color.RED -> println("Color is Red")
        Color.GREEN -> println("Color is Green")
        Color.BLUE -> println("Color is Blue")
    }

    when (clientRole) {
        "Administrator", "User" -> println("clientRole == 'Administrator' or clientRole == 'User'")
        "ProductOwner" -> println("Im ProductOwner")
        else -> println("Else")
    }

    when (clientRoleLevel) {
        in 1..10 -> println("level is in the range")
        !in 10..20 -> println("level is in the range")
        else -> println("Else")
    }

    println(clientRoleSummary)

    /* Ranges
    * The most common way to create a range in Kotlin is to use the .. operator.
    * For example, 1..4 is equivalent to 1, 2, 3, 4.
    * # To declare a range that doesn't include the end value, use the ..< operator.
    * For example, 1..<4 is equivalent to 1, 2, 3.
    * # To declare a range in reverse order, use downTo.
    * For example, 4 downTo 1 is equivalent to 4, 3, 2, 1.
    * # To declare a range that increments in a step that isn't 1, use step and your desired increment value.
    * For example, 1..5 step 2 is equivalent to 1, 3, 5.
    * # Char ranges
    * 'a'..'d' is equivalent to 'a', 'b', 'c', 'd'
    * 'z' downTo 's' step 2 is equivalent to 'z', 'x', 'v', 't'
    * */

    /* Loops
    * for: iterate over a range of values and perform an action.
    * while: to continue an action until a particular condition is satisfied.
    * just worked for -> has a member or an extension function iterator() that returns Iterator<>
    * */

    // * For
    val startRange: Int = 1
    val endRange: Int = 10
    val cakes: List<String> = listOf("carrot", "cheese", "chocolate")
    val weapons: Set<String> = setOf("AK-47", "M4A1", "RPG")
    val products: Map<String, String> = mapOf(
        "Tablet" to "Table (Price: $500)",
        "Laptop" to "Laptop (Price: $1200)"
    );

    // From startRange to endRage (1,2,3,..,10)
    for (index in startRange..endRange) {
        println(index)
    }

    // From startRange to endRange (1,2,3,..,10) (#Method-2)
    for (index in startRange.rangeTo(endRange)) {
        println(index)
    }

    // From startRange to until endRange (1,2,3,..,9)
    for (index in startRange..<endRange) {
        println(index)
    }

    // From startRange to until endRange (1,2,3,..,9) (#Method-2)
    for (index in startRange until endRange) {
        println(index)
    }

    // From startRange to endRange with Step (1,4,7,10)
    for (index in startRange..endRange step 3) {
        println(index)
    }

    // From startRange to until endRange with Step (1,4,7)
    for (index in startRange..<endRange step 3) {
        println(index)
    }

    // From endRange to startRange (10,9,8,..,1)
    for (index in endRange downTo startRange) {
        println(index)
    }

    // From endRange to startRange (10,9,8,..,1) (#Method-2)
    for (index in endRange.downTo(startRange)) {
        println(index)
    }

    // From endRange to until startRange (10,9,8,..,2)
    for (index in endRange downTo startRange + 1) {
        println(index)
    }

    // From endRange to startRange with Step (10,7,4,1)
    for (index in endRange downTo startRange step 3) {
        println(index)
    }

    // From endRange to until startRange with Step (10,7,4)
    for (index in endRange downTo startRange + 1 step 3) {
        println(index)
    }

    // Hybrid start to end with step 3
    for (index in startRange.rangeTo(endRange).step(3)) {
        println(index)
    }

    // Hybrid end to start with step 2
    for (index in endRange.downTo(startRange).step(2)) {
        println(index)
    }

    // Iterate From list with Value
    for (cakeName in cakes) {
        println(cakeName)
    }

    // Iterate From list with Index & Value
    for ((index, cakeName) in cakes.withIndex()) {
        println("$index : $cakeName")
    }

    // * Iterate From set with Value
    for (weaponName in weapons) {
        println(weaponName)
    }

    // * Iterate From set with Index & Value
    for ((weaponIndex, weaponName) in weapons.withIndex()) {
        println("$weaponIndex $weaponName")
    }

    // Iterate From map with index & value
    for ((productId, productSummary) in products) {
        println("$productId --> $productSummary")
    }

    /*
    * While
    * While : while and do-while loops execute their body continuously while their condition is satisfied
    * while -> check the condition and if it's satisfied, execute body
    * do-while -> execute body and then check the condition, if it's satisfied, the loop repeats
    * */
    var whileCounter = 10;

    while (whileCounter >= 1) {
        whileCounter--;
    }

    whileCounter = 10;

    do {
        println(whileCounter)
        whileCounter--;
    } while (whileCounter >= 1)

    /*
    * Label
    * Any expression in Kotlin may be marked with a label.
    * Labels have the form of an identifier followed by the @ sign, such as abc@ or fooBar@. To label an expression, just add a label in front of it.
    * */
    loop@ for (number in 1..5) {
        // ...
    }

    /*
    * Returns & Jumps in (return, break, continue)
    * return -> by default returns from the nearest enclosing function or anonymous function.
    * break -> terminates the nearest enclosing loop.
    * continue -> proceeds to the next step of the nearest enclosing loop.
    * in first you need to know about labels in kotlin
    * */
    loop@ for (number in 1..20) {
        if (number % 2 == 0) {
            continue@loop
        }
        println(number)
    }

    loop@ for (number in 1..20) {
        if (number == 10) {
            break@loop
        }
        println(number)
    }

    // * Return to labels
    fun foo() {
        listOf(1, 2, 3, 4, 5).forEach {
            if (it == 3) return // non-local return directly to the caller of foo()
            print(it)
        }
        println("this point is unreachable")
    }
    foo()

    // -> Note that such non-local returns are supported only for lambda expressions passed to inline functions.
    // To return from a lambda expression, label it and qualify the return:
    fun bar() {
        listOf(1, 2, 3, 4).forEach lit@{
            if (it == 3) return@lit
            print(it)
        }
        println(" done with implicit label")
    }
    bar()

    // -> use better name for your labels in returns and bindings
    // Note : Often it is more convenient to use implicit labels, because such a label has the same name as the function to which the lambda is passed.
    fun betterBar() {
        listOf(1, 2, 3, 4).forEach {
            if (it == 3) return@forEach // local return to the caller of the lambda - the forEach loop
            println(" done with implicit label")
        }
    }
    betterBar()

    // example with anonymous functions
    fun anoBar() {
        listOf(1, 2, 3, 4).forEach(fun(value: Int) {
            if (value == 3) return // local return to the caller of the anonymous function
            print(value)
        })
        println(" done with anonymous function")
    }

    anoBar()

    // Note : When returning a value, the parser gives preference to the qualified return:
    fun betterBarWithValue() {
        run loop@{
            listOf(1, 2, 3, 4).forEach {
                if (it == 3) return@loop 1403
            }
        }
    }

    println(betterBarWithValue())

    /*
    * Exceptions
    * Note -> All exception classes in Kotlin inherit the Throwable class.
    * Every exception has a message, a stack trace, and an optional cause.
    * try is an expression, which means it can have a return value:
    * */
    try {
        throw Exception("Hi There !")
    } catch (error: Exception) {
        println("Catch Error To Prevent Application Trouble - Exception Message :  ${error.message}")
    } finally {
        println("Yes we handle that exception [Finish]")
    }

    // handler return value (example: if you can't convert the value to Int, don't worry we considered a default value)
    val input: Any = "Hello";
    val convertedValue: Int? = try {
        throw NumberFormatException("test")
    } catch (e: NumberFormatException) {
        1403 // at here we write what we need to return as exception handler result
    }

    println(convertedValue)

    // throw exception as else of this condition
    val newInputValue = input ?: throw IllegalArgumentException("input required")

    /*
    * Use Imported Packages
    * */
    Helper().printForMe(API_ENDPOINT_URL)
    HelloBabe().bye()
    HelloBabe().myExtensionName("Test")
}