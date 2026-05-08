package com.learning.learnkotlin

fun main() {
    val result = add(4,5)
    println(result)
    val result2 = add(5,6)
    println(result2)
    evenorOdd(12)
    evenorOdd(13)
    printmessage(3)//argument
    printmessage()
}
// block of code perform particular operations,help to reuse
fun add(num1:Int,num2:Int) = num1+num2
//{
    //val sum = num1 + num2
    //return sum
//}
fun evenorOdd(num1:Int){
    val result = if(num1 %2 ==0) "Even" else "Odd"
    println(result)
}
//by default agr koi fn return na kr rha ho to us ka return type unit hota
fun printmessage(count:Int = 2){ //count= parameter , val type
    for(i in 1..count){
        println("Hello $i")
    }
}