fun main() {
    //logical Operators
    val user = "Admin"
    val password = "1234"
    println("logical and &&")
    var authentic = (user == "Admin" && password == "1234")
    println(authentic)
    println("------------------------------------------")


    println("logical OR ||")
    authentic = (user == "Admin" || password == "5678")
    println(authentic)
    println("------------------------------------------")



    println("logical NOT !")
    var isavailable = true
    println("available: ${!isavailable}")
    println("------------------------------------------")


    //short circuit
    //-> In AND operator if first condition is false it does not check 2nd condition
    //-> In OR Operator if the first condition is true it does not check the 2nd condition


    println(" short circuiting in OR")
    var i = 10
    var j = 20
    var result = i == 10 || j++ == 20
    println(result)
    println(i)
    println(j)
    // in this case first condition is true result is true it does not check 2nd condition in which j is incremented.it show same value of j.
    println("------------------------------------------")


    println(" short circuiting in AND")
   result = i == 11 && j++ == 20
    println(result)
    println(i)
    println(j)
    // in this case first condition is false result is false it does not check 2nd condition in which j is incremented.it show same value of j.
}
