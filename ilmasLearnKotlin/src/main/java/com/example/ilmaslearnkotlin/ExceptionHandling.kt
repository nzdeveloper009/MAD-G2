package com.example.ilmaslearnkotlin

fun main(){
    //Exception handling is used to handle runtime errors so that the program does not crash and runs smoothly.

    // divide by zero
    var s=2
    val result=10/s
    try {
        s=0
    } catch (e: Exception) {
        println("Error occurred")
    }
    println(result)
    println("-------------------------")


    val arr=arrayOf(1,2,3)
    try {
        println(arr[5])
    }
    catch (e:Exception){
        println(" please check index number")
    }
    finally {
        println(" it will Execute no matter Exception will come or not ")
    }
    // multiple catch class Exception
    try {
        println(arr[5])
    }catch (e: NullPointerException){// as there can be multiple errors  occur so we use multiple catch
        println(" Null pointer")
    }
    catch (e:Exception){// main exception class first it check null pointer then it
        println(" please check index number")
    }
    finally {// it is optional we can write or not it's up to you but if you write it must be executed
        println(" this will Execute no matter Exception will come or not ")
    }
    createList(2)
    //createList(-2)
}
fun createList(value:Int){
    if (value<0){
        //exception raise
        throw IllegalArgumentException("Value must be greater than zero")
    }
    else{
        println(" value is $value")
    }

}