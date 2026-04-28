package com.example.ilmaslearnkotlin

fun main(){
    val cal=Calculator()
    println(cal.add(3,4))
    println("----------------------")
    println("Getter")
    val p2=Persons("ali",23)
    println(p2.name)
  println("Setter")
    p2.age=-30
}

//Getter and setter

class Persons(nameparam:String,ageParam:Int){
    val name:String=nameparam
        get(){
            println("name getter called")
            return field.uppercase()
        }
    var age:Int=ageParam
        set(value) {
            if (value>0){
           field=value
            }
            else{
                println("Age can't be negative")
            }
        }


}
//lateInit
class Calculator{
    // properties can not be initialized without default values for this purpose we use lateInit
    // lateInit describe that our property will be initialized later
   lateinit var  message:String
    fun add(m:Int,n:Int):Int{
        return m+n
    }
    fun mul(m:Int,n:Int):Int{
        return m*n
    }

}