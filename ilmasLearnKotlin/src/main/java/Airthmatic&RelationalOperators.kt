fun main(){
    // Airthmatic operators
    val a = 10
    val z=2
    println("sum of $a and $z is :${a+z}") //12
    println("sub of $a and $z is :${a-z}")  //8
    println("mul of $a and $z is :${a*z}")  //20
    println("Div of $a and $z is :${a.toFloat()/z}")   //5.0    int->float data type change


    // modulus operator
    val i =13
    val j= 2
    println( " modulus of $i and $j is :${i%j}" )  //1


    // relational operators
    val b=5
    val c=7

    println(b>c)  //false
    println(b<c)   //true
    println(b>=c)  //false
    println(b<=c)    //true
    println(b==c)   // false
    println(b!=c)  //true



    println("pre &post increment")
    //addition of 1 in variable


    //pre increment
    var age=20
    println("pre increment in $age is:${++age}")  // in this statement age variable modified first then print

    var year=2001
    println("post increment in $year")
    println(year++)  // in this case first print value of year then modified value  stored in memory

    println("modified value after post increment : $year")

println("post & pre decrement")
    //decrease value by 1

    println("pre decrement in $age is:${--age}")
    println("post decrement in $year")
    println(year--)  // in this case first print value of year then modified value  stored in memory

    println("modified value after post decrement : $year")


}