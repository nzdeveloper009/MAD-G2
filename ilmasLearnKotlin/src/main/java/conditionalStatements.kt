fun main(){
    val user = "Admin"
    val password = "1234"
    println("if else")
    if (user == "Admin" && password == "1234"){
        println("Welcome to the system")
    }
    else{
        println("wrong username or password")
    }

    println("------------------------------------------")



    //if-else-if
    println("if-else-if")
    var x=10
    var y=5
    if(x>=y){
        println("x is greater than y")
    }
    else if(x<=y){
        println("x is less than y")
    }
    else{
        println("x is equal to y")
    }
    println("------------------------------------------")






    //if else as an expression
    println("if else as an expression")
    var num=23
    val result=if(num%2==0) "Even" else "Odd"
    println(result)
    println("------------------------------------------")




    //when statement
    //We use when why:
    //we want to compare one variable with many possible values
    //we want to avoid writing many if-else if statements
    //we want code to be shorter and easier to understand


    val day = 3

    when (day) {
        1 -> println("Monday")
        2 -> println("Tuesday")
        3 -> println("Wednesday")
        4 -> println("Thursday")
        5 -> println("Friday")
        else -> println("Weekend")
    }

    println("------------------------------------------")
    // as expression
    println("when as a expression")
    val number=13
    val output= when(number){
        11-> "Eleven"
        12 -> "Twelve"
        in 13..19 -> "teen"
        else -> "twenty"
    }
    println(output)
    println("------------------------------------------")


    // range in kotlin
    println("range in kotlin")
    val a=10
    var check= a in 1..10
    println(check)  // it just return whether the number is in the range or not
    println("------------------------------------------")
    check= a in 1 until 10
    println(check)  // it just return whether the number is in the range or not excluding the last number like here last number is 10.
    println("------------------------------------------")
}