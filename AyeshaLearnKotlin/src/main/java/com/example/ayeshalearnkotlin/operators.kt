package com.example.ayeshalearnkotlin

//arithmatic operators
fun main()
{
    var c = 13
    var d = 7
    println(c + d)
    println(c - d)
    println(c * d)
    println(c.toFloat() / d) //if both values are nt , it will answer in an integer value , to get the answer in decimal we have to use "to.Float()" with any one of thrm
    println(c%d)

    //relational operators
    println(c < d)
    println(c > d)
    println(c >= d)
    println(c <= d)
    println(c == d)
    println(c != d)

    //increament operator

    println(c++) //post: value is used first then increamented
    println(++c) //pre: first its incremented then used
    //decreamnet operator
    println(d--)   //post: value is used first then decreamented
    println(--d)   //pre: first its decremented then used
}

