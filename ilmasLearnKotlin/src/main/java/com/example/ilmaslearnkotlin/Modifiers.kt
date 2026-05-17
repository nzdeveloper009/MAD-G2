package com.example.ilmaslearnkotlin
//Public-----can be access everywhere
//by default public
//Internal -----only accessible in one module ----can be with variable and method
//private ---- accessed within class
//protected----only available in sub-Classes not everywhere
fun main(){
    var obj=B()
   println(obj.s) // because s is internal in this module we can access them
    println(obj.p) // because p is public

}
open class A{
    public var p=10
    private var q=15
    protected var r=20
    internal var s=13

}

class B:A(){
    fun test(){
        println(p)
        //println(q)  // here we could not access the q because q is private it is accessible in the same class only
        println(r)
        println(s)
    }
    /// why we use modifiers
    //Data Hiding (Encapsulation)
   // Security
   // Control access (Restriction)
    //Avoid unwanted changes
}
