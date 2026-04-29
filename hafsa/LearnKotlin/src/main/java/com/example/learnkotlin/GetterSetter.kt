package com.example.learnkotlin

fun main() {
var p1= Person1("hafsa",18)

    println(p1.age)
    p1.age=0
    println(p1.name)


    var password= Account()
    password.pass="hafsa"
    println(password.pass)
}


class Person1(var namePrm:String, var agePrm:Int,) {

    var name = namePrm
        get(){
            return field.uppercase()
        }
    var age = agePrm
        set(value) {
            if (value > 0) {
                field = value
            } else {
                println("age can't be negative or 0")
            }
        }
}

class Account{
    var pass=""
        set(value){
            if(value.length>8){
                field=value
            }else{
                println("Enter atleast 8 characters")
            }
        }
}