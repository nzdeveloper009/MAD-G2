package com.example.amanlearnkotlin
fun main(){
    var i:Int=20 //property value base expressions perform
    println(i.plus(other = 30)) //user defined data, data ko manipulate krny k lye functuons hty hyn
    println(i.toFloat())//data aur funs t\ko hum class mein enclose krty hyn
    val p1= Person(name="A",age=21)
    val p2= Person(name="B", age=17)
    println(p1.canVote())
    println(p2.canVote()) //methods apni property ki value ki base pr kam krty hyn actions perform klrty hy
}

class Person(val name:String, var age:Int){
    fun canVote():Boolean{
        return age>18
    }
}