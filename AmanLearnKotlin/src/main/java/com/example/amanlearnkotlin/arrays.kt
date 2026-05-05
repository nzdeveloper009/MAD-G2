package com.example.amanlearnkotlin

fun main() {
    var arr = arrayOf("one", "two", "three")
    var arr1 = arrayOf(1, 2, 3)

    for ((i, e) in arr.withIndex()) {
        println("$i   $e")
    } //zero based array
    println(arr[0])
    println(arr.get(1))
    arr.set(0,"hello")
    println(arr[0])
    println(arr.size)
    println(arr[3])

}