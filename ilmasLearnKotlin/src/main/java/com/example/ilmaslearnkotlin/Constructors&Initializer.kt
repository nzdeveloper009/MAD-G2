package com.example.ilmaslearnkotlin

fun main(){
    //primary Constructor
    var car=Automobile("car",4,5,"Petrol")
    //secondary constructor
    var car2= Automobile("car","diesel")

    //types of primary constructors
    val p1=Person("ali",20)
    val p2=Person2("ahmad",30)
    println(p2.name)
   println(p2.isVote)

}

//constructor
// initialize the object and provide the default values to properties
//Primary constructor in Kotlin is used to initialize class properties at the time of object creation
class Automobile( val name:String,val tyres:Int, var maxSeats:Int,engineType:String){
    //Initializers
    //Initializer in Kotlin is used to assign an initial value to a variable or execute setup code
    // when an object is created. The init block is used as a class initializer.
    init{
println("$name is created")
    }

     // Secondary constructors
    //Secondary constructor in Kotlin is used to create additional ways of initializing a class object.
     // It is defined using the constructor keyword. If a primary constructor exists,
     // the secondary constructor must call it using this().
    constructor(nameparam:String,engineParam:String):
            this(nameparam,tyres=4,maxSeats=5,engineParam)
    fun driveCar(){
        println(" $name Car is driving")
    }
    fun applyBrakes(){
        println(" $name Brakes applied")
    }
}


//two ways to initialize the primary constructor
// var or val with parameters behaves likes properties of class without var or val it behaves like parameters of function
// in this way  we can perform operation on the properties like concat or conditions
class Person(val name:String,val age:Int){

}
// in this type of primary constructor we can apply som operation on the parameters it behaves like function
class Person2(nameparam:String,p_age:Int){
    val name="$nameparam.clan"
    val age=p_age
    val isVote:Boolean=age>18
}