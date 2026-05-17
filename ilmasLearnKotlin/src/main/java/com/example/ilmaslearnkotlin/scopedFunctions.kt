package com.example.ilmaslearnkotlin

fun main(){
    val emp= employe()
    emp.name="Ali"
    emp.age=20// manual method to assign value to class properties




// assign value to class properties using apply fun

    emp.apply {// no need to write emp. again and again
        name="Sara"
        age=25

    }// its return type is object
    println(emp)





    //Let function
    println(emp.age)// simple method to get class properties
    emp.let {
        println(it.name)
        // its return type its last statement type like now its return type is unit cause println has no type
        "hello"
    }


    with(emp) {
        age=17
    }



    emp.run {
        name="ahmad"
        age=25
    }


}
data class employe(var name:String="", var age:Int=0)