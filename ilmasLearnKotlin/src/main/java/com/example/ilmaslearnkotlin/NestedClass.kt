package com.example.ilmaslearnkotlin

fun main(){
    val nest= outer()// obj of outer class
    val nest1= outer.nested()// obj of nested class
    nest1.test()
    // object of inner class
    val obj= outer1().nested1()
    obj.test()
}
class outer{
    val i=0
    class nested{
        fun test(){
            println("i am in nested class ")
        }
    }
}
//without inner use we cant access outer class property in inner class
class outer1{
    val i=0
    inner class nested1{
        fun test(){
            println("i am in nested class $i")
        }
    }
}