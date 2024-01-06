package org.example.common

/*
* Interface
* Interfaces in Kotlin can contain declarations of abstract methods, as well as method implementations.
* What makes them different from abstract classes is that interfaces cannot store state.
* They can have properties, but these need to be abstract or provide accessor implementations.
* */

interface IRouter {
    val routerInitialPath: String;
}

interface IHelper {
    fun test() {
        println("test")
    }
}

interface ICrudController : IRouter {
    override val routerInitialPath get() = "/"
    val routerPath: String;

    fun create()
    fun findAll(): List<String> {
        // optional body
        return listOf<String>("Default");
    }

    fun remove()
}

// * Implementing
class UserCrudController : ICrudController, IHelper {
    override val routerPath: String = "/users/"

    init {
        super<ICrudController>.findAll();
        super<IHelper>.test();
    }

    override fun create() {
        TODO("Not yet implemented")
    }

    override fun remove() {
        TODO("Not yet implemented")
    }
}

data class RouterConfig(
    override val routerInitialPath: String,
    val input: String,
) : IRouter
