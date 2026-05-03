package com.example.amanlearnkotlin

fun main(){
    /*val isRaining = true //boolean
    if(isRaining == true){
        println("take umbrella")
    }
    else {
        println("No rain- enjoy your day")
    } */
    /*val x=10
    val y=11
    if(x>y){
        println("x is greater than y")
    }
    else if(x<y){
        println("x is less than y or equal to y")
    }
    else{
        println("x is equal to y")
    }
    //we can use if else as an expression

     */
    val number=20
    val result=if(number%2==0){
        "even"
    }
    else{
        "odd"
    }

    print(result)
}