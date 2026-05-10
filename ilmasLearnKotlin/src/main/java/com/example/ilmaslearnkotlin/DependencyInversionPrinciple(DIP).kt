package com.example.ilmaslearnkotlin
//High-level modules should not depend on low-level modules.
// Both should depend on abstractions.
//Abstractions should not depend on details(low level module). Details(low level module) should depend on abstractions.

// violation DIP
//class MySQLDatabase {
//    fun save(data: String) {
//        println("Saving to MySQL: $data")
//    }
//}
//
//class UserService {
//    private val db = MySQLDatabase() // Tight coupling
//
//    fun registerUser(name: String) {
//        db.save(name)
//    }
//}


//using DIP
interface Database {
    fun save(data: String)
}
class MySQLDatabase : Database {
    override fun save(data: String) {
        println("Saving to MySQL: $data")
    }
}

class FirebaseDatabase : Database {
    override fun save(data: String) {
        println("Saving to Firebase: $data")
    }
}

class UserService(private val db: Database) {

    fun registerUser(name: String) {
        db.save(name)
    }
}

fun main() {
    val mysql = MySQLDatabase()
    val firebase = FirebaseDatabase()

    val userService1 = UserService(mysql)
    userService1.registerUser("Ali")

    val userService2 = UserService(firebase)
    userService2.registerUser("Sara")
}

