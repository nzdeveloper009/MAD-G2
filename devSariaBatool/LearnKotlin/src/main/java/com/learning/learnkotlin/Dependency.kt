package com.learning.learnkotlin

// Dip , high level concrete class should not depend on low level concrete class
// instead both should depend on abstractions
//Abstraction should not depend on details instead details depend on abstractions
interface Database {
    fun saveUser(username: String)
}
class SqlDatabase : Database {
    override fun saveUser(username: String) {
        println("Saving $username to SQL Database")
    }
}

class MongoDatabase : Database {
    override fun saveUser(username: String) {
        println("Saving $username to Mongo Database")
    }
}


class UserController(private val database: Database) {

    fun registerUser(username: String) {

        database.saveUser(username)
    }
}


fun main() {

    val sqlDb = SqlDatabase()
    val controller1 = UserController(sqlDb)
    controller1.registerUser("Rahul")


    val mongoDb = MongoDatabase()
    val controller2 = UserController(mongoDb)
    controller2.registerUser("Amit")
}