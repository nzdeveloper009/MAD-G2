package com.example.ayeshalearnkotlin

//BEFORE DIP
/*
class Email {
    fun send() {
        println("Email sent")
    }
}
class NotificationService {
    private val email = Email()
    fun notifyUser() {
        email.send()
    }
}
fun main() {
    val notification = NotificationService()
    notification.notifyUser()
}
*/

// After DIP
class NotificationService(private val service: MessageService) {
    fun notifyUser() {
        service.send()
    }
}
interface MessageService {
    fun send()
}
class Email : MessageService {
    override fun send() {
        println("Email sent")
    }
}
class SMS : MessageService {
    override fun send() {
        println("SMS sent")
    }
}
fun main() {
    val emailNotification = NotificationService(Email())
    emailNotification.notifyUser()
    val smsNotification = NotificationService(SMS())
    smsNotification.notifyUser()
}