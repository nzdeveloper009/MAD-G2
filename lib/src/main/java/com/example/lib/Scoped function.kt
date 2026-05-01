package com.example.lib
// Scoped function -> utlity function
// ally ,let,with, run
fun main(){
    val emp= employe()
    emp.name="Sanila"
    emp.age=19// manual method to assign value to class properties
// assign value to class properties using apply fun
    emp.apply {
        name="Amna"
        age=19
    }// its return type is object
    println(emp)
    //Let function
    println(emp.age)// simple method to get class properties
    emp.let {
        println(it.name)
        // its return type its last statment type like now its return type is unit cause println has no type
        "hello"
    }
    with(emp) {
        age=17
    }
    emp.run {
        name="fatima"
        age=50
    }


}
data class employe(var name:String="", var age:Int=0)