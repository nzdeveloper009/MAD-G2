package com.example.lib
interface Notificationn{
    fun send(message: String)

}
class EmailNoti: Notificationn{
    override fun send(message: String) {
        println("Email send message $message")
    }

}
class smsNoti: Notificationn{
    override fun send(message: String) {
        println("Sms send message $message")
    }

}
class whatsappNoti: Notificationn{
    override fun send(message: String) {
        println("Whatsapp send message $message")
    }

}
object NotificationFcatory{
    fun create(type: String): Notificationn=when(type){
        "email"-> EmailNoti()
        "SMS"-> smsNoti()
        "whatsapp"-> whatsappNoti()
        else -> throw IllegalArgumentException("Unknow $type")
    }

}

// Abstract Factory
interface Button{
    fun render()
}
interface TextField{
    fun render()
}
interface Card{
    fun render()
}
 //light classes
class LightButton: Button{
     override fun render() {
         println("Light Button")
     }

 }
class ligthText: TextField{
    override fun render() {
        println("Light Text")
    }

}
class lightcard: Card{
    override fun render() {
        println("Light card")
    }

}
// DARK class
class DarkButton: Button{
    override fun render() {
        println("Dark Button")
    }

}
class DarkText: TextField{
    override fun render() {
        println("Dark Text")
    }

}
class Darkcard: Card{
    override fun render() {
        println("Dark card")
    }

}
// Absract Factory interface
interface UIFactory{
    fun createButton(): Button
    fun createTEXT(): TextField
    fun  createcard(): Card
}
// concrete factories
class ligththemeFactory: UIFactory{
    override fun createButton()= LightButton()

    override fun createTEXT()= ligthText()

    override fun createcard()= lightcard()

}
class DarkthemeFactory: UIFactory{
    override fun createButton()= DarkButton()

    override fun createTEXT()= DarkText()

    override fun createcard()= Darkcard()

}
fun buildScreen(factory: UIFactory){
    factory.createButton().render()
    factory.createTEXT().render()
    factory.createcard().render()
}
/*fun main(){
    println("Ligth")
    buildScreen(ligththemeFactory())
    println("Dark")
    buildScreen(DarkthemeFactory())
}*/

//  Factory  Using sealed class
sealed class noTification {
    // abstract function — har subclass implement karegi
    abstract fun send(message: String)

    // Sab types ANDAR hain — alag files nahi chahiye!
    class Email : noTification() {
        override fun send(m: String) = println("Email: $m")
    }

    class Sms : noTification() {
        override fun send(m: String) = println("SMS: $m")
    }

    class WhatsApp : noTification() {
        override fun send(m: String) = println("WhatsApp: $m")
    }


    companion object {
        fun create(type: String): noTification = when (type) {
            "email"    -> Email()
            "sms"      -> Sms()
            "whatsapp" -> WhatsApp()
            else -> throw IllegalArgumentException("Unknown: $type")
        }
    }
}
fun main() {
    val n1 = noTification.create("email")
    n1.send("Order confirmed!")

    val n2 = noTification.create("sms")
    n2.send("OTP: 9271")
}