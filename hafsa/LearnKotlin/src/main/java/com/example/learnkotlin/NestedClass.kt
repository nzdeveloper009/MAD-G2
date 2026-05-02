package com.example.learnkotlin

import com.sun.jdi.Value

fun main() {
    var obj=Outer.Nested()
    obj.display()

    // outer constructor call first
    var obj1 = Outer().Inner()
    obj1.display2()

    //with Int
    var isContainer= Container<Int>(5)
    isContainer.GetVal()

    //with String
    var strCont= Container<String>("Hafsa")
    println(strCont.data)

    Add(1,2,2,3,4,5,6)
}

class Outer{

    class Nested{
        fun display(){
            println("i'm in nested class")
        }
    }
    inner class Inner{
        fun display2(){
            println("i'm in inner class")
        }
    }
}


// general container se kisi bhi type ki class bna skty hein just type specify kr k
// classes with same logic but different data types
class Container<T>(var data:T){
    fun SetVal(value: T){
        data = value
    }

    fun GetVal():T{
        return data
    }
}

//function for vararg
fun Add(vararg values:Int){
    var sum=0
    for(i in values){
        sum=sum+i
    }
    println(sum)
}