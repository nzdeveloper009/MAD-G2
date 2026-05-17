package com.example.ilmaslearnkotlin


// single responsibility principle
//a class should have only one reason to change ,meaning that it should
//have only one responsibility or job
// each class have single specific purpose to design
// the change in class occur if and only if when the functionality changed
fun main(){

}
//violation of SRP
   //class user(){
    //var name:String=""
    //var email:String=""
    //constructor (name:String,email:String){
      //  this.name=name
        //this.email=email

    //}
    //fun SavetoDatabase(){
      //  println("saving $name with email $email to the database ")
    //}
    //fun GenerateReport(){
      //  println("Report Generated ")

    //}
    //fun Sendemail(){
      //  println("sending email to : Name: $name emali: $email ")
    //}
//}

//SRP Implementation
class user(){
    var name:String="ali"
        get() {
            return field.uppercase()
        }
    var email:String="ali@gmail.com"
        get() {
            return field.toString()
        }

}

class NotificationServices{
    fun sendEmail(user1:user){
    println("sending email to : Name: ${user1.name}emali:${user1.email}")
    }
}
class ReportGenerator{
    fun Reportgenerate(user1:user){
        println("user Report Generated")
    }
}
class DataToFile{
    fun SavedatatoFile(user1:user){
        println("storing Name: ${user1.name}emali:${user1.email} to database")
    }
}
