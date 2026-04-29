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

    var result= c==13 && d==7  //and opt:if both are true , result is true otherwise false
    println(result)
    var total= c==13 || d==5  //or opt: if anyone of them is true , result is true
    println(total)
    println(!total)   //not opt : if result is true it changws to false , if false it changes to true
    // short circuiting: if answer is detectable by just checking the first condition it doesnt check the second condition doesnt magtter what function is performimg t it.
    var resultt= c==15|| (++d)==c
    println(d)
}

