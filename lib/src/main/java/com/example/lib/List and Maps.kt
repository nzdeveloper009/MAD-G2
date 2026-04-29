package com.example.lib
//Mutable List can be Change
// Immutable  List cant be change
fun main(){
    val num: List<Int> = listOf(1,2,3)// immutable list
    println(num.indexOf(2))
    println(num.contains(8))
    val num2: MutableList<Int> = mutableListOf(1,2,3)
    num2[2]=4
    num2.add(5)
    num2.remove(3)
    val list2=listOf(23,56)
    num2.addAll(list2)// merage 2 lists
    //Maps-> key value pair
    val std=mutableMapOf<Int, String>()
    std.put(1,"Sanila")
    std.put(2,"Amna")
    std.put(3,"Eman")
    println(std.get(1))// to get elements
    for ((key:Int,value:String) in std){
        println("$key $value")
        std[3]="Ume"
        val m=mapOf<Int, String>(1 to "Apple",2 to "Banana")// USR TO operator for adding value
        println(m)
    }



}
