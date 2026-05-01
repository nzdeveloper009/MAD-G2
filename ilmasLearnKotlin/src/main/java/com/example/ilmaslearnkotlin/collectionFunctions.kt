package com.example.lib
// collection function-> .foreach() .map() .filter()
fun main(){


    val list=listOf(1,2,3,4,5,6,7,8,9)
    val nums=list.filter(::isodd)
    println(nums)
    val nums1=list.filter({a: Int->a%2!=0})// pass function as lambda
    println("------------------------------------------")



    val userlist=listOf(user(1,"Ali"),
        user(2,"Amir"))
      val res=  userlist.filter{it.id==1}
      println(res)
    println("------------------------------------------")




    //Maps--- perform any operation on list
    val map= nums.map{it*it}
    val paidu=userlist.map{paidUser(it.id,it.name,type="Paid")}
    println(paidu)
    println("------------------------------------------")



    // for each --- for traversal
    nums.forEach{println(it)}

}
fun isodd(a:Int): Boolean{
    return a%2!=0
}
data class user(val id:Int, val name: String)
// map fun ------------ data from one form to another
data class paidUser(val id: Int,val name: String,val type: String)