package com.example.lib

fun array(){
    var arr=arrayOf("one","Two","Three")
    var arr1=arrayOf<Int>(1,2,3,4)
    for (i in arr1)
        println(i)
    // PRINT Array with Index
    for ((i,e) in arr.withIndex())
    {
        println("$i -> $e")
    }
    arr1[0]=6
    arr1.set(3,8)// Get and Set
    println(arr.get(2))
    for (i in arr1){
        println(i)
    }
    // Print size of ARRAY
    println(arr1.size)

}

//  Classes And Objects
class car(val name: String, val type: String,kmRun: Int, speed:Int){// class with properties
    val km: Int=kmRun
    fun driveCar(){
        println("Car $name is Driving")
    }
    fun applyBreaks(){
        println("breaks is Applied on $name")
    }
    //Secondary Constructors
    constructor(namepara: String,typepara:String):this(namepara,typepara,4,677)
}
class person(nampara: String,agepara: Int){// class with parameters
val name: String="$nampara.clan"// Getters and Setters
    get() {
        return field.uppercase()
    }
    var age : Int=agepara
        set(value) {
            if (age>19)
                field=value
            else{
                println(" age can't be Neg!")
            }
        }
    init {// init block if we have to print in class
        println(" person name is $name")
    }
}
// default constructor
private class calculator{
    fun add(a: Int,b: Int):Int{
        return a+b
    }

}



