package com.example.learnkotlin

fun main() {
    println("welcome to kotlin")
    val a =45
    val b = 9

    // arithmetic operators
    println(a+b)
    println(a-b)
    println(a*b)
    println(a/b)

    // relational operators
    println(a>b)
    println(a<b)
    println(a<=b)
    println(a>=b)
    println(a==b)
    println(a!=b)

    // logical operators
    println(a==b||a>b)
    println(a!=b&& a>b)

    // some builtIn fun of string
    var name = "Hafsa Noor"
    println(name)

    println(name[6])   // specific element
    println("third element: " + name[2])

    var rollNo = "24011519-151"
    println(name + rollNo )   // add two strings
    println("characters in RollNo: " + rollNo.length) // length
    println(name.uppercase()) // HAFSA NOOR
    println(name.lowercase())  //hafsa noor

    println(name.compareTo("Hafsa Noor"))  // for compare 2 strings
    println(rollNo.indexOf("519"))  //it returns the index of the first occurrence of a specified text

    println("My name $name and rollNo is $rollNo") //template



}
