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
    val button = object : ClickListener {
        override fun onClick() {
            println("Button clicked")
        }
    }

    button.onClick()
    println("--------------------")


    // obj within a class
    println("obj within a class")
    Myclass.f()// companion
    Myclass.anotherobj.g()
    println("--------------------")

// Factory Pattern`
    println("Factory Pattern")
    var pizza1= Pizza.create("tomato")
    println(pizza1)
    var pizza2= Pizza.create("peppy panner")
    println(pizza2)
    println("--------------------")

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
// Companion Objects
class Myclass{
    companion object myobj{// now  we don't need to write myclass.myob.f we can myclass.f()
    @JvmStatic// IT tell that it behave like a static method in java with this class
    fun f(){

        println("first object (companion) ")
    }
    }
    object anotherobj{        // it is not a companion object
        fun g(){
           println("Another object function")
        }
    }
}
// Factory Pattern
class Pizza ( val type: String, val topping: String){
    companion object Factory{
        fun create(pizzaType: String): Pizza{// IT NOW return an object
            return when(pizzaType){
                " tomato" -> Pizza("Tomato","tomato, cheese")
                "peppy panner"-> Pizza("panner","panner")
                else -> Pizza("Basic","onion")
            }

        }
    }
    override fun toString():String{
        return "Pizza(type=$type,toppings=$topping)"
    }
}
