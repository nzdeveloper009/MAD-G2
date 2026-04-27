package com.example.learnkotlin

fun main() {

    println("funtions are on the way...")
    print("Enter 2 integers to find maximun: ")
    var num1 = readLine()!!.toInt()
    var num2 = readLine()!!.toInt()
    var res= max(num1,num2)
    println("maximum number is $res")

    println("Check even or odd")
    evenOrodd(num1)
    evenOrodd(num2)

    var result = factorial(4)
    println(result)
}



// MAXIMUM
fun max ( a: Int, b : Int): Int {
    if(a>b){
        return a
    }else{
        return b
    }
}

//unit means void
fun evenOrodd(num: Int): Unit{
    if(num%2==0){
        println("$num is even..")
    }else{
        println("$num is odd..")
    }
}

fun factorial(num:Int):Int{
    var res = 1
    for(i in 1..num)
    {

        res= res*i
    }
    return res
}