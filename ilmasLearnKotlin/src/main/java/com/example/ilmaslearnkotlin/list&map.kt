package com.example.ilmaslearnkotlin

import kotlin.collections.iterator
// ***** why we need of list
//We use List instead of Array because it is dynamic, more flexible, and provides many built-in functions for easier data handling.
//Mutable List can be Change
// Immutable  List cant be change
fun main(){
    // immutable list
    val num: List<Int> = listOf(1,2,3)
    println(num.indexOf(2))
    println(num.contains(8))
    //  num.add(4)  // it gives us error because it is immutable list which can not b change or modifies


    // mutable list
    val num2: MutableList<Int> = mutableListOf(1,2,3)
    num2[2]=4
    num2.add(5)
    num2.remove(3)

    // merge 2 lists
    val list2=listOf(11,15)
    num2.addAll(list2)
    println(num2)






    //Maps-> key value pair
    //Map is used to store data in key–value pairs, allowing fast and organized access using unique keys.
    //mutable-------immutable

    val std=mutableMapOf<Int, String>()
    std.put(1,"Rayan")
    std.put(2,"John")
    std.put(3,"kattie")
    println(std.get(1))// to get elements
    for ((key:Int,value:String) in std){
        println("$key $value")
        // modify---set
        std[3]="Bob"

        //immutable
        val m=mapOf<Int, String>(1 to "Apple",2 to "Banana")// USR TO operator for adding value
        println(m)
    }



}