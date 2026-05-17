package com.example.ilmaslearnkotlin

fun main(){
    println("extension functions")
    val name = "Almas"
    println(name.greet())
    println("--------------------------------")
    println("Inline Functions")
    val tempLambda = { println("Hello World") }
    sayHello(tempLambda)
    println("----------------------------------")

}
// Extension Function
// Extension functions allow you to add new functions to an existing class without modifying its code or open keyword.
// we can access its private members
fun String.greet(): String {  // greet function added in string class
    return "Hello, $this"
}

//Inline-functions
//Inline functions improve performance by avoiding function call overhead, especially when using lambda functions.
//Compiler copies the code directly where function is called
// No extra object -> faster execution
inline fun sayHello(action: () -> Unit) {
    println("Before")
    action()
    println("After")
}
