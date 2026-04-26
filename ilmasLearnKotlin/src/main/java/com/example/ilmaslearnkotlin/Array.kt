package com.example.ilmaslearnkotlin

fun main(){
    // Array
    //  object that  store multiple values of the same data type
    //fixed size --- size can't be changed later
     var arr = arrayOf("one","Two","three")     // array of strings ---implicitly defined datatype -- automatically  detect that this array hold string values

    var arr2=arrayOf(1,2,3,4)
    //explicitly datatypes define
    var arr3=arrayOf<Int>(5,6,7)


    println("access array elements")
    println(arr[0])
    println(arr.get(1))
    println("set the value of specific element")
    arr.set(2,"Hello")
    println(arr[2])
    println("size")
    println(arr.size)
    //out of bounds exception it return error message when we tried to access the element out of range
   // println(arr[3])



    // when we want to access element with its index number
    println("element with the index number")
    for((i,e) in arr.withIndex()){   // i is index and e is element in arr
        println("$i- $e")

    }


}