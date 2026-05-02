package com.example.ayeshalearnkotlin
//every class has a super class which is "ANY" , there are bult in methods in "ANY" class which are automatically inherited to the subclasses, like in this case scenario "person1" has a super class "Any"
fun main(){
   var p1= professor("OOP")
    p1.InUOG()
    p1.teaches()
    var p2= Student(semester=4)
    p2.InUOG()
    p2.enrolled()
}
// person1 is a parent class , which has to be "open" to be inherited
open class person1(){
    //we can also write properties in primary constructor , but then , we have to pass valaues when that consrtructorb is inherited
    val name:String="Ayesha"
    val age:Int=20
    val gender:String="Female"
    init {
        println("parent constructor is called")
    }
    //fun of parent class is opened , so it can be override in child classes.Similarly , properties can also be opened for child classes
    open fun InUOG(){
        println("$name is in the system")
    }
}
//professor ia a child class of person1, one child class can have only one parent class
class professor(val subject: String): person1(){
    //whenever object of child class is created , constructor of parent clas is called first
 init {
     println("constructor of professor class is called")
 }
    fun teaches(){
        println("$name teaches $subject in UOG")
    }
// "InUOG" is overridden in this class
    override fun InUOG() {
        super.InUOG()
        println("$name is in faculty")
    }
}
class Student(val semester:Int): person1(){
    init {
        println("constructor of student class is called")
    }
    fun enrolled(){
        println("$name is enrolled in $semester semester")
    }
}
