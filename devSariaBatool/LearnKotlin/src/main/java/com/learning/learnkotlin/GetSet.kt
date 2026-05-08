package com.learning.learnkotlin

fun main() {

    val s1 =Staff("zainab" , 21)
    println(s1.age)
    s1.age=23
    s1.age=-12
    println(s1.name)


    val ob= calculator()
    println(ob.add(5,9))
    println(ob.multiply(4,9))


}
class Staff(nameParam:String,ageParam:Int){
    var name:String = nameParam
        get(){
            println("Name getter is called")
            return field.uppercase()
        }
    var age:Int = ageParam
        set(value){
            if (value>0){
                field=value
            }
            else{
                println("Age can't be negative")
            }
        }
 var email: String=""
     get()=field
     set(value){
         field=value
     }
}
class calculator{

     lateinit var message:String
    fun add(a:Int,b:Int):Int{
        return a+b
    }
    fun multiply(a:Int,b:Int):Int{
        return a*b
    }
}

