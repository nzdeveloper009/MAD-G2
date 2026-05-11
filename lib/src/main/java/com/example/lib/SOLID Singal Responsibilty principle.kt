package com.example.lib

// A class should have only one reason to change means a class must have just one responsibilty
class contentManger{// a class that voilate SRP
fun  createContent(){}
    fun update(){}
    fun delete(){}
    fun archiverContent(){}
    fun searchContent(){}
    fun login(){}
}
// Region Refactored follow SRP
class Archiver{
    fun archiverContent(){}
}
class login{
    fun login(){}
}
// Example 2 File Manger
fun main(){
    val log= logger()
    val noti= notification()
    val file= fileManger()

}
class fileManger(){
    fun openfile(logger: logger,notification: notification){
        val logger=logger
        val not=notification
        println(" file is opend $not")
    }
    fun closefile(logger: logger,notification: notification){
        val logger=logger
        val not=notification
        println(" file is Closed $not")
    }

}
class logger{
    fun logAction(action: String, filename: String){
        println("Login acyion $action + $filename")
    }
}
class notification{
    fun send(message: String){
        println(" sending Notification $message")
    }

}
