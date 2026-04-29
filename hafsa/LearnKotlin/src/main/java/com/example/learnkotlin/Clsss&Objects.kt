package com.example.learnkotlin

import java.net.InetAddress

fun main() {
    var s1= Student("Hafsa",19,"CS")
    var s2= Student("Ilmas", 20, "CS")

    s1.upload()
    s2.payfee()

}

class Student(var name: String, var age:Int, var dept:String ){

    fun upload(){
        println("$name uploaded an assignment")
    }

    fun payfee(){
        println("name: $name  department: $dept  fee is paid")
    }

}