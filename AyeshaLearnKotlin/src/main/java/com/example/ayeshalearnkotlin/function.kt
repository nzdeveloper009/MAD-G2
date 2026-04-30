package com.example.ayeshalearnkotlin

fun main(){
    val result= add(  5 ,  6 )
    println(result)
    println(sub(6,3))
    print()
}
//a function which doesnt have a return type has a default "unit" return type
fun add(num1:Int , num2: Int ): Int {
    val sum=num1+num2
    return sum
}
//inline function
fun sub(n1:Int , n2: Int) = n1-n2
//even if  we dont pass parameters, func will run 2 times
fun print(dev:Int=2) {
    for(i in 1..dev){
        println("hello world")
    }
}