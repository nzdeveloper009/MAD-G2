package com.example.lib

fun learn(){// variables and data type
    var age=5
    println(age)
    age=40
    println(age)
    val name: String="Sanila"
    println(name)
    var isranining: Boolean=false
    var alpha : Char='A'
    println( isranining)
    println(alpha)
}
fun operators(){
    var i=13
    var j=2
    println(i-j)//arthmetic opreations
    println(i+j)
    println(i*j)
    println(i.toFloat()/j)
    println(i%j)
//Relational operators

    println(i>=j)
    println(i!=j)
    println(i==j)
    //increment decrement operators
    println(i++ + ++i)
    println(i--)
    println(i)

}
fun if_else(){
    var x=10
    var y=15
    if(x>y)
        println("x is greater")
    else if(x<y)
        println("Y is greater ")
    else
        println("Both are Equal")
    // Or
    var num=49
    val result=if(num%2==0){
        "Even"
    }else{
        "odd"
    }
    println(result)
}
fun Range_When(){
    var num=5
    var result: String
    var res=num in 1..5// 5 is included
    println(res)
res =num in 1 until 5// 5 is not incliuded
    println(res)
    // When
    var day="Friday"
    when(day){
        "Monday" -> println("today is Mon")
        "Tuesday" -> println(" today is Tuesday")
        "Friday"-> println( " Today is Fri")
        else -> println("Invaild")
    }
    var number=5
    result= when(number){

        1-> "one"
        2-> "TWO"
        3->"three"
        in  4 until 8 -> "in Range"
        else -> "invaild"

    }
    println(result)
}
fun loops(){
    var n=1
    while (n<=10){
        println("kotlin")
        n++
    }
    var num=2
    var i=1
    while (i<=10){
        println("$num x $i = ${i*num}")
i++
    }

}