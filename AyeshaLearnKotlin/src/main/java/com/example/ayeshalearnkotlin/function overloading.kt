package com.example.ayeshalearnkotlin

fun main()
{
 println(mul(2,3))
    println(mul(2,3,4))
}
fun mul(g: Int , h: Int): Int{
    val product=g*h
    return product
}
fun mul(g:Int , h:Int , i:Int):Int{
    val product=g*h*i
    return product

}