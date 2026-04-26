package com.example.ilmaslearnkotlin
fun main(){




    println(" simple parameter function")
    val result=add(2,3) //arguments
    println(result)

println("---------------------------------------")

    println(" Default arguments")
       greet()





println("  simple print statement formats")
    println("hello world " )
    println(1 )
    println(false)
    // println move control on the next line but
// simple print statement print next statement on the same line.
    print("hello world")
    print(1)
    print(false)
    println("---------------------------------------")
}



    // function is the block of code to perform certain functionality
// that help to reuse the code

fun add(num1:Int,num2:Int): Int{
    val sum=num1+num2
    return sum
}


// default arguments when user not pass the argument function use parameter value
//unit data type used when function return nothing
// unit maybe write or maybe not
fun greet(count:Int=2):Unit{ //parameters
    for(i in 1..count)
    println("Hello $count")

}