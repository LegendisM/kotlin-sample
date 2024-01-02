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

    // * Inline-condition
    val resultCondition = if (trueCondition == falseCondition) "Yes" else "No"
    println("Short If result : $resultCondition")

    // * When : conditional expression with multiple branches. (like 'switch' in other languages
    // * Note : when can be used either as a statement or as an expression
    val clientRole: String = "Administrator"
    val clientRoleSummary: String

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
    * */

    // * For
    // TODO: Here (implement for example code)

    // * While
    // TODO: Here (implement for example code)
}