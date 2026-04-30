package com.example.lib
// collection function-> .foreach() .map() .filter()
fun main(){
    val list=listOf(1,2,3,4,5,6,7,8,9)
    val nums=list.filter(::isodd)
    println(nums)
    val nums1=list.filter({a: Int->a%2!=0})// pass fun as lambda
      val userlist=listOf(user(1,"sanila"),
     user(2,"Amna"))
  val res=  userlist.filter{it.id==1}
    println(res)
    //Maps
    val map= nums.map{it*it}
    val paidu=userlist.map{paidUser(it.id,it.name,type="Paid")}
    println(paidu)
    // for each
    nums.forEach{println(it)}

}
fun isodd(a:Int): Boolean{
    return a%2!=0
}
data class user(val id:Int, val name: String)
// map fun data from one form to another
data class paidUser(val id: Int,val name: String,val type: String)