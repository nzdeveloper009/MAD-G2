package com.example.lib
fun  main(){
val cat1= Cat()
    cat1.make_sound()
    //Mobile
    val p1= smartphone("Smart")
    p1.display()
    p1.make_call()
    val p2= Mobile("Simple")
    p2.make_call()
    println(p1.toString())// Any class fun calling

}
  open class Animal(val leg:Int=0,val eye_color: String="") {
    init {
        println("this is parent class")
    }
    fun make_sound(){
println(" Animal can make sound")
    }
    fun walk(){
        println(" Animal is waking")
    }

}
class Cat: Animal(){
    init {
        println("this is child class")
    }
    fun eat(){
        println(" Cat eat food")

    }


}
//overriding
open class Mobile(val type: String){
     open val name: String=""
   open val size:Int=5
   open fun make_call(){
        println(" Calling From Moblie")
    }
     open fun  display(){
        println("Simple Dispaly")
    }
}
open class smartphone(paratype: String): Mobile(paratype){
    override val size: Int=10
    override val name: String="vivo"
    override fun make_call() {
        super.make_call()
        println("$name make call")
    }

    override fun display() {
        println("$name has $type")
    }
    //Any class Fun overide
    override fun toString(): String {
        return super.toString()
        return " Name : $name"
    }
}