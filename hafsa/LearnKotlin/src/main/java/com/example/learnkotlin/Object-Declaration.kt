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
}