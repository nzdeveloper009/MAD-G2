package com.example.learnkotlin

object DatabaseManager {

    var dbName = "StudentDB"

    fun connect() {
        println("Connected to database: $dbName")
    }

    fun disconnect() {
        println("Disconnected from database")
    }
}

open class Database {
    open fun connect() {
        println("Default database connection")
    }
}

fun main() {
    DatabaseManager.connect()
    DatabaseManager.dbName = "EmployeeDB"
    DatabaseManager.connect()
    DatabaseManager.disconnect()

    val tempDB = object : Database() {

        override fun connect() {
            println("Temporary connection to TestDB only")
        }

        fun runQuery() {
            println("Running test query...")
        }
    }

    tempDB.connect()
    tempDB.runQuery()


    println("obj within a class")
    Myclass.f()// companion
    Myclass.anotherobj.g()


    println("Factory Pattern")
    var pizza1= Pizza.create("tomato")
    println(pizza1)
    var pizza2= Pizza.create("Tikka")
    println(pizza2)
}


// Companion Objects
class Myclass{
    companion object myobj{
    @JvmStatic// static method in java
    fun f(){

        println("first object (companion) ")
    }
    }
    object anotherobj{        //not a companion object
        fun g(){
            println("Another object function")
        }
    }
}
// Factory Pattern
class Pizza ( val type: String, val topping: String){
    companion object Factory{
        fun create(pizzaType: String): Pizza{//return object
            return when(pizzaType){
                " tomato" -> Pizza("Tomato","tomato, cheese")
                "fajita"-> Pizza("fajita","jo bhi")
                else -> Pizza("Basic","onion")
            }

        }
    }
    override fun toString():String{
        return "Pizza(type=$type,toppings=$topping)"
    }
}