package com.learning.learnkotlin

fun main() {
    val number = 5
    val result = number in 1 until 5
    println(result)
    range()
    second()

}
// until uper bound not  include
// .. uper bound  include

fun range(){
    val animal = "Dog"
    //if(animal == "Horse"){
      //  println( "Animal is Horse")
    //}
    //else if(animal == "Cat"){
      //  println("Animal is Cat")
    //}
    //else if(animal == "Dog"){
      //  println("Animal is Dog")
    //}
    //else{
      //  println("Animal not found")
    //}
   val result = when(animal){
      "Horse" -> "Animal is Horse"
        "Cat" -> "Animal is Cat"
        "Dog" -> "Animal is Dog"
        else -> "Animal not found"
    }
    println(result)
}
fun second(){
    val number = 14
    val result = when(number){
        12 -> "Twelve"
        13 -> "Thirteen"
        14 -> "Fourteen"
        else -> "Not in range "
    }
    println(result)
}