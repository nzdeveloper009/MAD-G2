package com.learning.learnkotlin

import kotlin.coroutines.coroutineContext

fun main() {
    var car= Automobile("Car",4,5, "carbon")
    var Car2= Automobile("Car2",4,5,"petrol")


    var person=Person("Saria",20)
    println(person.age)
    println(person.name)
    var person2= Person("Ali",18)
    println(person2.age)
    println(person2.name)
}
class Automobile(val name:String,val types:Int,val maxSeating:Int,
                 val enginetype:String ){//primary constructor
    init{
        println("$name is created")

    }
    init{
        println("2nd Block")
    }

    constructor(nameParam: String,ageParam: Int):this(nameParam,4,
        5,"Petrol")
    fun drive(){}
    fun applyBreaks(){}
}
//class Empty{}

class Person(nameParam:String,ageParam:Int){
    val name:String = "$nameParam  - Clan"
    var age:Int =ageParam
    var canVote: Boolean=ageParam>18
}
