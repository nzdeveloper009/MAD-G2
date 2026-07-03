package com.example.learnkotlin

//before OCP
/*class Notification {

    fun sendNotification(type: String) {

        if (type == "Email") {
            println("Notification sent through Email")
        }
        else if (type == "SMS") {
            println("Notification sent through SMS")
        }
        else {
            println("Invalid Notification Type")
        }
    }
}*/

//agr WhatsApp Notification add karni ho to isi class mein naya else if likhna parega
// Matlab existing class modify hogi

//after OCP

interface Notification {
    fun send()
}

class Email : Notification {

    override fun send() {
        println("Notification sent through Email")
    }
}

class SMS : Notification {

    override fun send() {
        println("Notification sent through SMS")
    }
}

class WhatsApp : Notification {

    override fun send() {
        println("Notification sent through WhatsApp")
    }
}

fun main() {

    val notification: Notification = WhatsApp()
    notification.send()
}