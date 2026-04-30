package com.example.ilmaslearnkotlin

fun main(){
    println("Object Declaration")
     println(X.num)
    Y.test()
    println("--------------------")
println("Singleton Object")
    sharingWidget.incrementTwitterLikes()
    sharingWidget.incrementFBLikes()
    sharingWidget.incrementTwitterLikes()
    sharingWidget.incrementFBLikes()
    sharingWidget.Display()
    println("--------------------")
    //Anonymous object---object without name
    // object expression
    val obj = object : Animal() {
        override fun sound() {
            println("Custom sound")
        }
    }

    obj.sound()

}
// object can be created without class
// object can have properties and methods similarly Class
// Class used to make multiple objects but object keyword made single one object
// no constructor
//init block is allowed
// you can inherit class/interface
object X{
    val num:Int=20

}
object Y{
    fun test(){
        println("I am object B")
    }
}


//sigleton object
object sharingWidget{
    private var TwitterLikes=0
    private var FbLikes=0
    fun incrementTwitterLikes()=TwitterLikes++
    fun incrementFBLikes()=FbLikes++
    fun Display()=println("Face book Likes :$FbLikes ---  Twitter Likes:$TwitterLikes")
}
//anonymous object
interface ClickListener {
    fun onClick()
}
