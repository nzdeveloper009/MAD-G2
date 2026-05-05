package com.example.amanlearnkotlin
fun main(){
    val result = add(num1=3 , num2=4)
    println(result)
    val result2= add(num1=8 , num2=12)
    println(result2)
    evenOrOdd(num1=4)
    evenOrOdd(num1=7)
    printmsg()
    printmsg(count=2)//argument
    }
fun add(num1:Int, num2:Int):Int {
    val sum= num1+num2
    return sum

}
fun evenOrOdd(num1:Int){
    val result=if(num1%2==0) "even" else "odd"
    println(result)
}
//unit datatype whose fns have no return type
//inlinefns bhu bna skty hyn
fun printmsg(count:Int=2) //default argument //val type variables in parameters
{
    for(i in 1..count){
        println("hello $i")
    }
}