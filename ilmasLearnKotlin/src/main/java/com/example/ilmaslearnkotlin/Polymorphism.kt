package com.example.ilmaslearnkotlin

fun main(){
   val circle:Shape=Circle(3.5)
   val square: Shape=Square(2.5)
    val shapes :Array<Shape> = arrayOf(Circle(3.5), Triangle(2.5,3.5),Square(2.5))
    calculateArea(shapes)

}
//polymorphism means many forms
// means one function or object can behave different
// two types----compile time polymorphism ----Rum time polymorphism
// compile time ------function  overloading
//run time --------Function or property overriding
fun calculateArea(Shapes:Array<Shape> ){
    for(shape in Shapes) {
        println(shape.area())
    }
}
open class Shape(){
    open fun area():Double {
        return 0.0
    }
}
class Circle(val radius:Double):Shape(){
    override fun area():Double {
        return Math.PI* radius* radius
    }
}
class Square(val side:Double): Shape(){
    override fun area():Double {
        return side*side
    }
}
class Triangle(val base:Double, val height:Double): Shape(){
    override fun area():Double {
        return 0.5*base*height
    }
}





//Advantages
//code reuse-ability
//Flexibility
//same interference,different Implementation
