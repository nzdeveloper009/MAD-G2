package com.example.amanlearnkotlin

fun main(){
    //range
    //in operator
    /*val number=10
    val result=number in 1  until 5//1,2,3,4 //5 is not included coz of until
    println(result)
    //.. includews uper bound
    val animal="dog"
    /*if(animal=="horse"){
        println("Shera,my horse")
    }
    else if(animal== "cat"){
        println("bella,my cat")
    }
    else if(animal=="dog"){
        println("Tommy, my dog")
    }
    else{
        println("animal not found")
    }

    */
    when (animal){
        "horse"-> println("Shera,my horse")
        "cat"-> println("bella,my cat")
        "dog"-> println("Tommy, my dog")
        else -> println("animal npt found")


    }


     */
    val number = 13
    val result = when(number) {
        11 -> "eleven"
        12 -> "twelve"
        in 13..19 -> "teen"
        else -> "not in range"
    }
    println(result)

}