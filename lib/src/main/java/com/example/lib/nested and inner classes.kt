package com.example.lib

fun main(){
     val nest= outer()// obj of outer class
    val nest1= outer.nested()// obj of ineer class
    nest1.test()
    // inner use
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
//with out inner use we cant access outer class property in ineer class
class outer1{
    val i=0
   inner class nested1{
        fun test(){
            println("i am in nested class $i")
        }
    }
}