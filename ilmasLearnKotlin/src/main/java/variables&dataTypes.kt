// two types of variables val and var
fun main(){
    //variable with var's value can change.
    println("var variable:")
    var score =5
    score=10
    println(score)

    println("val variable:")
    val name="Ilmas Shabbir"
//    name="ayesha"
    // val  variables behave like constant once we initialize its value we can not change its value .
    println(name)




    //datatypes

    //integer(Byte, Short, int, long)
    //Floating(Float,Double)
    //Boolean(True, false)
    //Character(char, String)


    println("Automatically datatype defined by value:")

    val number=30            // its data type is integer
    val message="hello world" // its data type is string
    println(number)
    println(message)
    // type checking( we cant re-assign the variable with different data type)
    //number=19.5              //its gives error




    println("explicitly datatype define:")
    val age: Int=40
    val greet: String="hello world"
    val isavailable: Boolean=true
    val grade: Char='a'
    println(age)
    println(greet)
    println(isavailable)
    println(grade)


}
