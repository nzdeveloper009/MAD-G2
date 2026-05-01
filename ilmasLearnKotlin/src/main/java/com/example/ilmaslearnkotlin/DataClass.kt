package com.example.ilmaslearnkotlin

fun main(){
    val p1= person1(1,"Ahmad")
    val p2= person1(2,"Sara")
    println(p1)
    println(p2)
    println(p1.hashCode())
    println(p1==p2)// equal method
    val p3=p1.copy()
    val p4=p1.copy(3)
    println(p3)
    println(p4)
    val(id:Int, name:String)= p1 // De-structure in this p1 id goes to id name pq name goes to name
    println(name)
    println(p1.component1())// p1 has two components name and id
}
data class  person1(val id: Int,val name: String) { // class that are used to store data only they don't have behavior


}