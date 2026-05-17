package com.example.ilmaslearnkotlin

fun main(){
    val con= container<String>("Summer ")
// List maps are generic classes
    val list=listOf<String>("")
    //vararg -> behave like a array
    sum(2,3,4,5,6,7)
}




class IntContainer(var data:Int){// It is a simple class it just deal with it value but if we have to apply same class on String type it does not work
// that's why we use generic classes
fun setvalue( value:Int){
    data=value
}
    fun getvalue(): Int{
        return data
    }
}
//Generic class
class container<T>(var data:T){
    fun setvalue(value:T){
        data=value
    }
    fun getvalue():T{
        return data
    }
}
//variable arguments
fun sum(vararg values:Int){// we can pass a variable number of parameters for this fun
    var sum=0
    for (i in values){
        sum+=i
    }
    println(sum)

}