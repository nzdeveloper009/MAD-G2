package com.example.lib
// open close principle
//Existing code must not be modify it can be extend
// we achive  this through polymorphism
class notificationn{// NOT FOLLOW OCP
    fun sendnoti(type: String,message: String){
        if (type.equals("Email")){
            println(" sending Email $message")
        }else if(type.equals("SMS")){
            println(" sending SMS $message")
        }else{
            println(" INVAILD ")
        }
    }
}
fun main(){
    val notify= emaIlNOT()
}
interface notificationService
{
    fun sendnoti(message: String)
}
class emaIlNOT:notificationService{
   override fun sendnoti(message: String){
        println(" sending Email $message")
    }
}
class SmsNoti: notificationService{
    override fun sendnoti(message: String) {
        println(" sending SMS $message")
    }

}