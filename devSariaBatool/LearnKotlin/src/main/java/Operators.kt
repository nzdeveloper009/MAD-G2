fun main() {
    var i =13
    var j = 2

    println(i+j)
    println(i-j)
    println(i*j)
    println(i.toFloat()/j)
    println(i % j)
    relationalMain()
    increment()
    preincrement()
    postincrement()
    preandpost()
}
//relational operator
//<,>,>=,<=,==,!=
fun relationalMain(){
    var i =13
    var j = 2

    println(i>j)
    println(i<j)
    println(i<=j)
    println(i>=j)
    println(i==j)
    println(i!=j)
}
//post and pre increment
fun increment(){
    var i = 10
    i++
    println(i)
    i--
    println(i)
}
fun postincrement(){
    var i= 12
    println(i++)
    println(i)
}
//post pehly use krta then increment krta
fun preincrement(){
    var i=7
    println(--i)
}
fun preandpost(){
    var i = 12
    println(i++ + ++i) // 12 + 14 = 26
}