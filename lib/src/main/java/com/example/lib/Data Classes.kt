package com.example.lib
fun main(){
    val p1= person1(1,"Sanila")
    val p2= person1(2,"Amna")
    println(p1)
val p3=p1.copy()// equal method
    val p4=p1.copy(3)
    val(id:Int, name:String)= p1 // Destructrue in this p1 id goes to id name pq name goes to name
    println(name)
    println(p1.component1())// p1 has two componets name and id
}
 data class  person1(val id: Int,val name: String) { // class that are used to store data only they dont have behavior


}