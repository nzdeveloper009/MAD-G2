package com.example.learnkotlin

fun main() {

    val list = mutableListOf("Hafsa", "Ayesha", "Ahmed")
    list.add("Zara")
    list.remove("Ali")

    println(list)
    println(list[0])
    println(list.contains("Sara"))

    for (item in list) {
        println(item)
    }

    val map = mutableMapOf<Int, String>()
    map.put(1,"Ali")
    map[2] = "hafsa"


    for ((key:Int,value:String) in map){
        println("$key $value")
        // modify
        map[2]="Noor"

        //immutable
        val m=mapOf<Int, String>(1 to "Computer",2 to "Science")
        println(m)
    }
}