package com.example.learnkotlin

fun main() {

    // normal function reference
    val fn = ::add
    println(fn(2,3))

    // higher order function call
    calc(4,5, ::add)


    // simple lambda
    val lam = {a: Int, b: Int -> a + b}
    println(lam(3,4))


    // direct pass
    calc(6,7, {x,y -> x*y})


    // single param
    val square = {x: Int -> x*x}
    println(square(5))

    val double = {it: Int -> it + it}
    println(double(10))

    val lam1 = {
        println("hello")
        val x = 2+3
        x
    }

    println(lam1())
}



// normal function
fun add(a: Int, b: Int): Int {
    return a + b
}


// higher order function
fun calc(a: Int, b: Int, op: (Int, Int) -> Int) {
    val res = op(a,b)
    println("answer: $res")
}