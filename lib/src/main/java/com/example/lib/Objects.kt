package com.example.lib

import java.util.Objects

fun main(){
    println(A.g)
    B.test()
    share.increment_F()
    share.increment_F()
    share.increment_T()
    share.display()
    // Object e EXPRESSION object without name
    //use obj expression forto define Anonymous inner classes
    var testob= object: clonable{// we can also Anonymous it by a class
        fun test(){
            println("I am in object Expression")
        }

        override fun clon() {
            println(" i am clonable")
        }

    }
    testob.clon()
    // obj within a class
    myclass.f()// companion
    myclass.anotherob.g()

// Factory Pattner`
    var pizza1= Pizza.create("tamato")
    println(pizza1)
    var pizza2= Pizza.create("peppy panner")
    println(pizza2)

}
interface clonable{
    fun clon()
}
object A{// object declartion
    val g:Int =10
    fun test(){
        println("I am object A")
    }
}
object B{// This object behave like singleton
    val num:Int =10
    fun test(){
        println("I am object B")
    }
}
object share{
    var twitter_likes=0
    var fb_likes=0
    fun increment_T(){
        twitter_likes++
    }
    fun increment_F(){
        fb_likes++
    }
    fun display(){
        println("facebook-> $fb_likes twitter -> $twitter_likes")
    }
}
// Companion Objects
class myclass{
     companion object myobj{// now  we don't need to write myclass.myob.f we can myclass.f()
         @JvmStatic// IT tell that it behave like a static method in java with this class
        fun f(){

            println("first object")
        }
    }
    object anotherob{
        fun g(){

        }
    }
}
// Factory Pattner
class Pizza ( val type: String, val toppiung: String){
    companion object Factory{
        fun create(pizzaType: String): Pizza{// IT NOW return an object
            return when(pizzaType){
                " tamato" -> Pizza("Tamato","tamatoo, cheese")
                "peppy panner"-> Pizza("panner","panner")
                else -> Pizza("Basic","onion")
            }

        }
    }
}