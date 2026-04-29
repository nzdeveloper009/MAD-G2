package com.example.lib
fun main(){
    val arr=arrayOf(1,2,3)
    try {
        println(arr[5])
    }catch (e:Exception){
        println(" please check index number")
    }
    finally {
        println(" this will Execute no matter Exception will come or not ")
    }
    println(" try this")
    // multie catch class Exception
    try {
        println(arr[5])
    }catch (e: NullPointerException){// as there can be multipy errors can occure so we use multipl catch
        println(" Null pointer")
    }
    catch (e:Exception){// main exception class firt it check nullpointer then it
        println(" please check index number")
    }
    finally {
        println(" this will Execute no matter Exception will come or not ")
    }
    create(2)
    create(-2)
}
fun create(value:Int){
    if (value<0){
        throw IllegalArgumentException("Value must be greater than zero")
    }
    else{
        println(" value is $value")
    }

}