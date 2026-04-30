package com.example.ayeshalearnkotlin

fun main () {
    var e = 27
    var f = 29
    var sum=e+f
    // if-else : it performs operation only if the condition is true other wise whole part under that condition gets skipped
    if (sum > 50){
        println("its above average")}
    else if (sum==50){
    println("its an exact average ")}
    else{
    println("its below average ")}

    // when statement: it works like switch statement in c++, its used to make a decision when we have multiple choices
    var studentname="Ayesha "
    when (studentname)
    {
        "Ayesha"->println("she is a girl")
        "hassan"->println("he is a boy ")
        "ilms "->println("she is a girl")
    }
}