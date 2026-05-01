package com.example.lib

import kotlin.time.Clock

fun main(){
    println("Hello World".formating())// this appoint to the object on which this function call
    // inline
    calculateTime { loop(1000) }
    calculateTime { loop(100000000) }
}
//we can extented some new function in existing class
fun String.formating(): String{// now this functionn extend a new function extend a fomating fun in String class
    return "-----------------\n $this \n----------------"

}
//inline function->no extra object making it paste the whole function where this fun call
fun  calculateTime(fn:()-> Unit){
    val start= System.currentTimeMillis()
    fn()
    val end = System.currentTimeMillis()
    println("tIME Taken:${start-end}")
}
fun loop(n: Long){
    for (i in 1..n){
        //
    }
}