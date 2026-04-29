package com.example.learnkotlin

fun main() {

    var arr= arrayOf(1,2,3)
    var arr2=arrayOf("Hafsa","Ayesha","Ilmas")

    for ((i, e) in arr2.withIndex())
        println("$i $e")

    println(arr[2])
    println(arr2.get(1))

    arr2.set(0,"Noor")
    println(arr2[0])
    println(arr.size)


    var students=arrayOf("hashir","Azan","Ali","Nawal","Ayzal","Haram","AbuBakr")
    var marks=arrayOf(55,45,50,60,47,35,50)

    for(i in students.indices){
        println("${students[i]} : ${marks[i]}")
    }

}