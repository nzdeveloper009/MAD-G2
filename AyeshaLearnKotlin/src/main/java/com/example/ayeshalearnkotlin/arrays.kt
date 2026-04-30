package com.example.ayeshalearnkotlin

fun main(){
    // implicit, when data type is determined itself
    val students= arrayOf ("Ayesha","Ali","Hassan")
    var rollNo= arrayOf (1,2,3)
    //explicit, when data type of array is defined
    val CGPA= arrayOf<Double>(3.2,3.3,2.6)
    //traverse values of array
    for ((i, e) in students.withIndex()) {
        println(" $i  $e")
    }
    //to print value of a specific index
    println(rollNo[2])
    //can also use get function:
    println(CGPA.get(1))
    //to set  value atv a specific index
    students.set(2,"Saman")
    //to know size of array
    println(students.size)
}