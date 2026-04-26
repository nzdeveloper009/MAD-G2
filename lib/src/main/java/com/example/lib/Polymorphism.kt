package com.example.lib



fun main(){
val c1: Shape= circle(5.8)
    println(c1.area())
    val s1: Shape= square(5.9)
    val shapes: Array<Shape> = arrayOf(circle(3.4), circle(6.8), square(5.7))
    fun cal_area(shapes: Array<Shape>){
        for(shape in shapes){
            println(shape.area())
        }
    }

    cal_area(shapes)
    fun printareae(shapes: Shape){
        println(shapes.area())

    }
    printareae(s1)
    printareae(c1)//same function but we can pass different objcts its possible bcz of polymorphism
}


 open class  Shape{
    open  fun area():Double{
        return 0.0
    }
}
class circle(val radius:Double): Shape(){
    override fun area(): Double {
        return Math.PI*radius*radius
    }

}
class square(val side:Double): Shape(){
    override fun area(): Double {
        return side*side
    }

}