package com.example.learnkotlin

fun String.reverseText(): String {
    return this.reversed()
}

inline fun execute(a: Int, b: Int, op: (Int, Int) -> Int): Int {
    return op(a, b)
}

inline fun calculateTime(fn:()-> Unit){
    val start = System.currentTimeMillis()
    fn()
    val end= System.currentTimeMillis()
    println("Time taken: ${end-start}ms")
}

fun Loop(n: Long){
    for(i in 1..n){}
}

fun main() {

    val name = "Hafsa Noor"
    println(name.reverseText())

    val result = execute(4,5) { x,y -> x + y }
    println(result)

    calculateTime {
        Loop(100000)
    }
}