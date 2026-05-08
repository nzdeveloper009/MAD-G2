package com.learning.learnkotlin

//object that store multiple values of same types,fixed size
fun main() {

    var arr = arrayOf("One", "two", "three")
    var arr1=arrayOf(1,2,3)

    var arr2=arrayOf<Int>(3,4,5)

    for ((i,e) in arr.withIndex()){
        println("$i  $e")
    }
    println(arr[0])
    println(arr.get(1))
    arr.set(0,"Hello")
    println(arr[0])
    println(arr.size)

}