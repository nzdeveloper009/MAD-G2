package com.learning.learnkotlin

//while loops, execute set of statements multiple times
// do while loop
fun main() {
    var count = 5
    while(count >= 1){
        println("Hello cheezycode")
        count--
    }
    table()
    dowhile()
}
fun table(){
    var number = 2
    var index = 1
    while(index<=10){ // 1 is less than 10 , true
        println(number * index) // 1*2=2
        index++ // next index 2 then repeat it until 10
    }
    println("Outside loop - " + index)
}
fun dowhile(){
    var index = 6
    do{  // firstly print then check condition
      println("Hello")
        index++
    }while(index>5)
}