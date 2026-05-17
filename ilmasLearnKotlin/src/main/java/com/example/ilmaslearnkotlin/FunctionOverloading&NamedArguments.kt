package com.example.ilmaslearnkotlin

fun main(){
    println("overloading function")
    var result= addition(2,3)
    println(result)
    var result2= addition(2.0,3.0,5.0)
    println(result2)
    println("----------------------------------------")


    println("named arguments")
    // it is easy to understand that which value is tobe assign to which parameter
    // reduce confusion
    // we can change order don't need to remember the order of parameter

    result=addition(num2=3,num1=7)
    println(result)


}





//function overloading
// same function name but different number of parameters or different data type of parameters

fun addition(num1:Int,num2:Int):Int{
    val sum=num1+num2
    return sum
}
fun addition(num1:Double,num2:Double,num3:Double):Double{
    val sum=num1+num2+num3
    return sum
}