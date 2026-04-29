package com.example.learnkotlin

import java.net.InetAddress

fun main() {
    var s1= Student("Hafsa",19,"CS")
    var s2= Student("Ilmas", 20, "CS")

    s1.upload()
    s2.payfee()

    var s3= Student("Ayesha") // Secondary constructor only call by this object

    val person= Person("Ali", 18)
    println(person.name)
    println(person.isVote)
}

class Student(var name: String, var age:Int, var dept:String ){

    // init block = constructor logic (auto call hota hai)
    init {
        println("Auto call for $name")
    }

    // Secondary constructor
    constructor(name: String) : this(name, 18, "Unknown") {
        println("Secondary constructor called for $name")
    }
    fun upload(){
        println("$name uploaded an assignment")
    }

    fun payfee(){
        println("name: $name  department: $dept  fee is paid")
    }

}

// in this type of primary constructor we can apply som operation on the parameters it behaves like function
class Person(nameparam:String,p_age:Int){
    val name="$nameparam.clan"
    val age=p_age
    val isVote:Boolean=age>18
}