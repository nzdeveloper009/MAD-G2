package com.example.ilmaslearnkotlin

fun main(){
   val mustang=Car("Petrol","mustang",500)
    val beetle=Car("Diesel","beetle",600)
    mustang.driveCar()
   beetle.applyBrakes()
}

//class is the blue-print or template
//Object is the real thing
//objects interact with each other to solve any problem
// design a class -----
//1 properties (Object knows)
//2 methods(object does)



class Car(val type:String, val name:String, var kmRan:Int){
    fun driveCar(){
        println(" $name Car is driving")
    }
    fun applyBrakes(){
        println(" $name Brakes applied")
    }
}