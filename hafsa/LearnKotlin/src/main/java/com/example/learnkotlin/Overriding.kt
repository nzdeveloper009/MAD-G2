package com.example.learnkotlin

fun main() {
    var obj = Dog()
    obj.Sound()

    // polymorphism yani parent type refference
//    var obj2:shape = circle(5.0)
//    obj2.area()
//    var s1:shape= rectangle(2.0,3.0)
//    s1.area()

    val arrOfshape = arrayOf(circle(2.0), rectangle(2.0,3.0), triangle(1.5,2.5))
    Area(arrOfshape)
}


open class Animal{
    open fun Sound()= println("Animal makes sound")
}
class Dog: Animal(){
    override fun Sound() {

        super.Sound()
        println("Dog is barking")
    }
}

fun Area(shapes: Array<shape>){
    for(shape in shapes){
        shape.area()
    }

}
open class shape{
    open fun area()=println("Area is calculating")
}
class circle(var r: Double) : shape(){
    override fun area(){
        println(Math.PI*r*r)
    }
}
class rectangle(var l:Double,var w:Double):shape(){
    override fun area(){
        println(l*w)
    }
}
class triangle(var h: Double, var b: Double):shape(){
    override fun area(){
        println(0.5*b*h)
    }
}