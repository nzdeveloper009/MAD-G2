package com.example.ilmaslearnkotlin
// open closed principle
// open for extend but closed for modification
//implemented using interface or abstract classes


fun main() {
    val service = NotificationServicess()

    val email = EmailNotification()
    val sms = SmsNotification()

    service.sendNotification(email, "Hello via Email")
    service.sendNotification(sms, "Hello via SMS")
}

// without ocp
class NotificationService {
    fun send(type: String, message: String) {
        if (type == "email") {
            println("Sending Email: $message")
        } else if (type == "sms") {
            println("Sending SMS: $message")
        }
    }
}

//with ocp
interface Notification {
    fun send(message: String)
}
class EmailNotification : Notification {
    override fun send(message: String) {
        println("Sending Email: $message")
    }
}

class SmsNotification : Notification {
    override fun send(message: String) {
        println("Sending SMS: $message")
    }
}
class NotificationServicess {
    fun sendNotification(notification: Notification, message: String) {
        notification.send(message)
    }
}

// add new functionality means extend the class
class PushNotification : Notification {
    override fun send(message: String) {
        println("Sending Push Notification: $message")
    }
}
