package com.example.ayeshalearnkotlin

fun main(){
    //we can only make object of inner class if we make an object of outer class already
    val inner=X().Y()
    inner.test1()
}
class X {
    var x = 1
//for nested class(Y) keyword"inner" is used , we cannot access properties of outer(X) class if we dont use this keyword
    inner class Y{
        fun test1() {
            println("i'm in nested class $x")
        }
    }
}