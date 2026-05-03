package com.example.ayeshalearnkotlin

fun main(){
    //for Int data type
    val icontainer=Container(3)
    println(icontainer.getvalue())
    //for String data type
    val scontainer= Container("Ayesha")
    scontainer.getvalue()
    add1(1,2,3,4,5,6,7,8,9,10)
}
//generic is a general class for a collection which has a same behavior for various data types, lists and maps are also generic collections
class Container<T>(var data:T){
    fun setvalue(value:T){
        data= value
    }
    fun getvalue():T{
        return data
    }
}
//vararg allows us to input multiple values in a function without specifiying the limit and the assosciated functionality will be performed accordingly
fun add1(vararg values:Int){
    var sum=0
    for(i in values){
        sum+=i
    }
    println(sum)
}
