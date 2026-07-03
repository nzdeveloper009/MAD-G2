package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// PROBLEM SCENARIO: Breaking the Dependency Inversion Principle (DIP)
// Here, we have a concrete low-level database controller class.
class SqlDatabase {
    fun saveUser(username: String) {
        println("SQL Query: Inserting $username directly into the users table.")
    }
}

// This is the high-level manager module.
// Look closely at the constructor: it initializes SqlDatabase using the 'new' keyword.
// This is a violation because UserController is completely stuck. If we want to change
// our database to MongoDB tomorrow, we have to rewrite this entire controller file.
// It also makes writing mock unit tests impossible.
class BadUserController {
    private val database = SqlDatabase()

    fun registerNewUser(name: String) {
        println("Processing registration requests...")
        database.saveUser(name)
    }
}


// FIXED SCENARIO: Adhering to the Dependency Inversion Principle (DIP)
// Instead of letting the high-level module look downward, we create an abstraction layer (Interface).
// The interface is designed based on what the high-level manager needs, not the database structure.
interface Database {
    fun saveUser(username: String)
}

// Low-level detail 1: SQL database now implements our abstraction
class GoodSqlDatabase : Database {
    override fun saveUser(username: String) {
        println("SQL Action: Saving $username securely into rows and columns.")
    }
}

// Low-level detail 2: Seamlessly adding MongoDB without affecting any existing codebase structures
class MongoDatabase : Database {
    override fun saveUser(username: String) {
        println("NoSQL Action: Saving $username as a BSON document inside a collection.")
    }
}

// The clean high-level module.
// Notice how it doesn't initialize or create any database tool inside its code.
// It simply demands a contract via constructor dependency injection.
// It is fully closed for modification but totally open for swapping different tool strategies.
class UserController(private val database: Database) {

    fun registerNewUser(name: String) {
        println("Validating user details on backend engine...")
        database.saveUser(name)
    }
}


// Orchestration engine testing runtime operations
fun main() {
    val newUserName = "Aman Zahra"

    // Connecting the high-level class with the SQL engine component
    val sqlDriver = GoodSqlDatabase()
    val standardController = UserController(sqlDriver)
    standardController.registerNewUser(newUserName)

    // Instantly switching the backend structure to NoSQL by injecting a different instance
    val mongoDriver = MongoDatabase()
    val modernController = UserController(mongoDriver)
    modernController.registerNewUser(newUserName)
}