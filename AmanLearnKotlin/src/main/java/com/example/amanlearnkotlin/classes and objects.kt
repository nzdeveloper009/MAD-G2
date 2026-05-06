package com.example.amanlearnkotlin.com.example.amanlearnkotlin

fun main(){
    val mustang=car(name="mustang",type="petrol",kmRan=100)
    val beetle=car(name="beetle",type="diesel",kmRan=200)

    println(mustang.name)
    println(mustang.type)
    println(beetle.name)
mustang.driveCar()

}
class car(val name:String,val type:String,var kmRan:Int){
    fun driveCar(){ //methods
        println("$name car is driving")
    }
    fun applyBrakes(){
        println("applied brakes")
    }
}