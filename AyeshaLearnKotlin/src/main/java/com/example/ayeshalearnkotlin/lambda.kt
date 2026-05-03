package com.example.ayeshalearnkotlin
fun main(){
    //a function is a higher order function when , a function is either passed as an input or returned as an output or both.
    calculator(5.0,5.0, ::sum)
    //lambda: a lambda is a nameless function , it can be a singleline or mutiline. In this case , it is passed as an input to calculator
    calculator(4.0,4.0){a,b->a*b}
    val nums=listOf(1,2,3,4,5)
    //filtering while passing method
    val a1=nums.filter (::isodd )
    println(a1)

    //filtering by passing lambda
    val a2 =nums.filter {a:Int-> a % 2!=0}
    println(a2)
    //filtering by using "it"keyword
    val a3=nums.filter {it % 2!=0}
    println(a3)
    val numss=listOf<Int>(1,2,3,4,5,6)
    //map function coverts every element of list from one form to another, we can also pass lambda in it
    val list=numss.map {  println(it.toFloat())}
    println(list)
    //for each is used to perforn the given function to each element of list
    val listt=numss.forEach { it * it}
    println(listt)
}
fun sum(a: Double,b: Double): Double{
    return a+b
}
//calculator is a higher order function
fun calculator(a:Double,b: Double,FN:(Double,Double)->Double){
    val result: Double=FN(a,b)
    println(result)
}
fun isodd(a: Int):Boolean{
    return a%2!=0
}