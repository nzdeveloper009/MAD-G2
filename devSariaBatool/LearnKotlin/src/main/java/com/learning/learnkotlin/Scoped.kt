package com.learning.learnkotlin

data class Employee(var name: String, var age: Int)

fun main() {
    val emp = Employee("John", 28)


    val empAfterApply = emp.apply {
        name = "Sean"
        age = 30
    }
    println("Apply Result: $empAfterApply")


    val letResult = emp.let {
        println("Let - Name: ${it.name}, Age: ${it.age}")
        "Finished printing ${it.name}"
    }
    println("Let Return Value: $letResult")


    val nullableEmp: Employee? = null
    nullableEmp?.let {

        println("This won't print because it's null")
    }



    val withResult = with(emp) {
        name = "XYZ"
        age = 40
        "Updated name to $name"
    }
    println("With Result: $withResult")



    val runResult = emp.run {
        name = "ABC"
        age = 35
        age + 10
    }
    println("Run Result (Age + 10): $runResult")
}