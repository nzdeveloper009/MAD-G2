package com.example.ayeshalearnkotlin

fun main()
{
    //Ayesha is a object of person classs
    var Ayesha=person("Ayesha",20,"Female","CS")
    //Class Methods are accessed by the objects of the classes
    Ayesha.prof("App Developer")
    var Abdullah=person("Abdullah",18,"Male","SE")
    Abdullah.canfreelance()
    var Team= cricketteam("Name",11,17)

}
//person is a class with attributes like name, age, gender,degree.Its a blueprint for real world objects like Ayesha and Abdullah.

class person(val name:String, val age:Int, val gender:String,  var degree:String)
{
    fun prof(profession:String)
    {
       println("$name is a $profession" )
    }
    //Methods in the classes behave acc to the attributes of the class
    fun canfreelance(){
        if(degree=="CS"||degree=="SE"){
            println("$name can be a freelancer ")
        }
    }
}
//Primary Constructor is used to give default values to the properties(attributes) of the class.
class cricketteam(val name:String,val totalmembers:Int,val age:Int){
    /*secondary constructor is initialized using keyword"constructor" in the class and the properties of primary constructor which are obvious are given values in this constructor.
    It must always delegate to the primary constructor using this(...).*/
    constructor(teamname: String,teamage:Int):this(teamname,11,teamage)
    //init block is executed automatically whenever object of a class is created , its a supporting block by which we can perform required logical operations
    init{
        if(age<18){println("Team must be under eighteen")}
    }
}