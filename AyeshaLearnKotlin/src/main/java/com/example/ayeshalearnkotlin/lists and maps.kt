package com.example.ayeshalearnkotlin

fun main(){
    //immutable list is a kind of collection like array but with dynamic size and memory , we cant update data in it like arrays
    var employee=listOf("Ayesha","Abdullah","Hassan")
    println(employee)
    //mutable list is a dynamic collection in which we can perform all kind of operation without worrying about the size of list
    var employer=mutableListOf("Saqib","Huzaifa","Adan")
    println(employer)
    employer.add("Hadeed")
    println(employer.get(3))
    println("After updation: $employer")
    //immutable maps are like immutable lists but we can store the element acc to out own declared key number
    var companies=mapOf(1 to "Netsole",2 to "Google")
    println(companies)
    //mutable maps
    var companiesthataccepted=mutableMapOf<Int,String>()
        companiesthataccepted.put(1,"Amazon")
        companiesthataccepted.put(2,"Apple")
        companiesthataccepted.put(30,"Cursor")
        companiesthataccepted.get(30)
        println(companiesthataccepted.get(5))
    println(companiesthataccepted)
        companiesthataccepted.remove(2)
    println(companiesthataccepted)
}