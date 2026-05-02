package com.example.ayeshalearnkotlin

fun main(){
    val  array=arrayOf(1,2,3)
    //We can use "try" with "catch" or "finally" to handle exceptions
    try {
        println(array[4])
    }
    // an exception can have more than one catch
    // if afrary will be null this exception will work
    catch (e: NullPointerException){

    }
    //if not than thus will execute
    catch (a: Exception){
        println("please check the index again ")
    }
    //it will execute no matter what , if try catch executes or not.
    finally {
        println("THANK YOU")
    }
}

