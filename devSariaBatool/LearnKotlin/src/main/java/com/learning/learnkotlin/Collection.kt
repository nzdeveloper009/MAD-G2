package com.learning.learnkotlin

fun main() {

    val nums = listOf(1, 2, 3)
    println("Index of element '3': ${nums.indexOf(3)}")
    println("Does list contain '4'?: ${nums.contains(4)}")


    val mutableNums = mutableListOf(1, 2, 3)
    mutableNums.add(5)
    mutableNums.remove(1)
    println("Mutable List after add/remove: $mutableNums")


    val list2 = listOf(11, 12)
    mutableNums.addAll(list2)
    println("List after merging: $mutableNums")



    val students = mutableMapOf<Int, String>()
    students.put(1, "Ryan")
    students[2] = "John"
    students[3] = "Katie"

    println("Student with ID 1: ${students[1]}")
    println("Student with ID 11 (Non-existent): ${students[11]}")

    println("Iterating over Students Map:")
    for ((key, value) in students) {
        println("ID: $key, Name: $value")
    }


    val immutableMap = mapOf(1 to "Hello", 2 to "World")
    println("Immutable Map: $immutableMap")
}