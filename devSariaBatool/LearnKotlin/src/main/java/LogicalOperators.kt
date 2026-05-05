fun main(){

    val above70 = false
    val knowsProgramming = true

    var calledForInterview = above70 && knowsProgramming
    println(calledForInterview)
    // OR
    calledForInterview = above70 || knowsProgramming
    println(calledForInterview)
    short()
    notfun()

}

fun short(){
    var i = 10
    var j= 11
    var result = i == 11 || j++ == 11
    println(i)
    println(j)
}
fun notfun(){
    //false --> !--> true
    //true --> !-->false
    val answer = false
    val result = !!answer
    println(result)
}