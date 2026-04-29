package com.example.learnkotlin

fun main() {

    var obj = Admin()
    obj.login()
    obj.name = "hafsa"
    println(obj.name)
    var obj1 = student()
    obj1.view()
}


open class User{
    var name= ""
    var age=18
    lateinit var contaact: String
    var Address=""

    fun login(){
        println("Login")
    }
    fun logOut(){
        println("LogOut")
    }
    fun view(){
        println("view")
    }
}

open class Admin:User()
{
    fun edit(){
        println("Edit")
    }
}

class student: Admin(){}























