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

fun main() {
    DatabaseManager.connect()
    DatabaseManager.dbName = "EmployeeDB"
    DatabaseManager.connect()
    DatabaseManager.disconnect()
}