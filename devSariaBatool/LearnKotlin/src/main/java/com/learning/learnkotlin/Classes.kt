package com.learning.learnkotlin


fun main() {
    val mustang = Car("mustang","petrol",100)
    val beetle = Car("beetle","diesel",200)
    println(mustang.name)
    println(mustang.type)
    println(beetle.name)

    mustang.driveCar()
    beetle.driveCar()
    beetle.applyBrakes()

   // val p1 =Person("A",21)
    //val p2=Person("B",17)
    //println(p1.canVote())
    //println(p2.canVote())

}
class Car(val name:String, val type:String,var kmRan:Int){
    fun driveCar(){ //methods
        println("$name Car id driving")
    }
    fun applyBrakes(){
        println("Applied Brakes")
    }
}

//class Person(val name:String,var age:Int){
  //  fun canVote(): Boolean{
    //    return age>18
    //}
//}