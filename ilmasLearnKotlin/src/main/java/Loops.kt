fun main(){
    // while loop
    val num=2
    var index=1
    while(index<=10){
        println("$num * $index = ${num*index}")
        index++
    }
    println("-----------------------------------")



    // do while loop
    // in do while if the condition is wrong then it execute the loop body for only one because while condition evaluate later the loop the body
    var a=5
    do{
        println("hello")
        a--
    }
    while(a>5)

    println("-----------------------------------")

    //For Loop
    println("For Loop")
    for(i in 1..5){
        println(i)
    }
    println("-----------------------------------")




    // in until last element not including in traversing
    println("until")
    for(i in 1 until 5){
        println(i)
    }
    println("-----------------------------------")




    // if we want to increment by 2 or any specific number then we use step
    println("step")
    for(i in 1..5 step 2){   //increment by 2
        println(i)
    }
    println("-----------------------------------")





    // Reverse order (decrement)
    println("down to")
    for(j  in 5 downTo 1){
        println(j)
    }
    println("-----------------------------------")







    // example
    println("example")
    val number=5
    for(i in 1..10){
        println("$number * $i = ${number*i}")
    }
    println("-----------------------------------")
}