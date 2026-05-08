package com.example.amanlearnkotlin

fun main() {
    val emp = Employee("John", 25)

    // 1. APPLY: Object ki properties set karne ke liye
    // Iska context 'this' hota hai aur ye object hi return karta hai
    emp.apply {
        name = "Aman"
        age = 30
    }
    println("Apply result: $emp")

    // 2. LET: Null-safety aur object par operations ke liye
    // Iska context 'it' hota hai aur ye aakhri line return karta hai
    emp.let {
        println("Employee Name: ${it.name}")
        println("Employee Age: ${it.age}")
    }

    // Null check ke sath let ka use
    var nullableEmp: Employee? = null
    nullableEmp?.let {
        // Ye code sirf tab chalega jab nullableEmp null nahi hoga
        println(it.name)
    }

    // 3. WITH: Jab aapko object ka naam baar-baar na likhna pare
    // Ye object as argument leta hai aur aakhri line return karta hai
    with(emp) {
        age = 35
        name = "Ali"
    }

    // 4. RUN: 'with' aur 'let' ka combination
    // Iska context 'this' hota hai aur ye transformation ke liye best hai
    val bio = emp.run {
        println("Processing employee...")
        "Name is $name and age is $age" // Ye string return hogi
    }
    println(bio)
}

data class Employee(var name: String, var age: Int)