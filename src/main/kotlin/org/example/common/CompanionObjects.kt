package org.example.common

/*
* Companion objects
* An object declaration inside a class can be marked with the companion keyword
* Members of the companion object can be called simply by using the class name as the qualifier
* it's like static definition in other languages
*/

// * Example 1
class ServiceManager {
    companion object {
        private val services: MutableList<String> = mutableListOf();

        fun addService(serviceName: String) {
            services.add(serviceName)
        }

        fun removeService(serviceName: String) {
            services.remove(serviceName)
        }
    }
}

// * Example 2
interface Connection {
    val uri: String;

    fun test(text: String)
}

class MysqlConnection {
    companion object : Connection {
        override val uri: String
            get() = ""

        override fun test(text: String) {
            println("Connection Test Passed $text")
        }
    }
}

// * Example 3
class Database {
    companion object Factory {
        fun create(): Database {
            return Database()
        }
    }

    fun connect(uri: String) {
        println("Connect to $uri")
    }
}

private fun main() {
    ServiceManager.addService("User")
    ServiceManager.Companion.addService("User2")
    ServiceManager.removeService("User")
    ServiceManager.Companion.removeService("User2")

    val mysqlConnection = MysqlConnection.test(MysqlConnection.uri)
    val mysqlConnection2 = MysqlConnection.Companion.test(MysqlConnection.uri)

    val db: Database = Database.create();
    val db2: Database = Database.Factory.create()
}