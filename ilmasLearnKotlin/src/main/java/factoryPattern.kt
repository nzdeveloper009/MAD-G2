package com.example.factory

//Factory Pattern means giving the responsibility of object creation to a separate class (Factory).
// The client simply asks for an object, and the Factory creates and returns the correct object.

// example
// user---> request---->email notification
// factory---> create ---> correct object(emailNotificationObject())
//user---->use it---> without knowledge how object is created


///           -------------------problems-----------------------------
//  Suppose you are building a food delivery app.
//The customer can choose to receive notifications through:
//Email
//SMS
//WhatsApp
//Now every screen that sends notifications has to decide which object to create.

//       if(type == "email"){
//    val notification = EmailNotification()
//    notification.send(message)
//}
//else if(type == "sms"){
//    val notification = SmsNotification()
//    notification.send(message)
//}
//else{
//    val notification = WhatsAppNotification()
//    notification.send(message)
//}

// Problem 1: Repeated Object Creation (Code Duplication)
//Problem 2: Too Many if-else Statements
// Problem 3: Tight Coupling
//Problem 4: Difficult Maintenance(violate open/closed principle)

///              without factory pattern
// suppose we have three notification classes

class EmailNotification {
    fun send(message: String) {
        println(" Email: $message")
    }
}
class SmsNotification {
    fun send(message: String) {
        println(" SMS: $message")
    }
}
class WhatsAppNotification {
    fun send(message: String) {
        println(" WhatsApp: $message")
    }
}
// Now imagine we have an Order Screen.

fun main() {

    val type = "email" // output: email object will be created and output will bw :order confirmed

    if(type == "email"){

        val notification = EmailNotification()
        notification.send("Order Confirmed")

    }else if(type == "sms"){

        val notification = SmsNotification()
        notification.send("Order Confirmed")

    }else if(type == "whatsapp"){

        val notification = WhatsAppNotification()
        notification.send("Order Confirmed")

    }
// Look carefully.
//The main() function is doing three jobs.
//Job 1:
//Deciding which object to create
//Job 2:
//Creating the object
//Job 3:
//Using the object


    //    factory pattern
    println("--------------------------------------------------")
    println("with factory pattern")
    var notification = NotificationFactory.create("email")

    notification.send("Order Confirmed")

    println(" add new notification with factory pattern")
    notification = NotificationFactory.create("push")

    notification.send("Order Confirmed")

    // abstract factory pattern
    println("--------------------------------------------------")
    println("with abstract factory pattern")
    println("Light Theme")

    buildScreen(LightThemeFactory())

    println()

    println("Dark Theme")

    buildScreen(DarkThemeFactory())
}

//---------------------------solution-----------------------------------
interface Notifications{

    fun send(message:String)

}
class EmailNotification2 : Notifications{

    override fun send(message:String){

        println(" Email: $message")

    }

}
class SmsNotification2 : Notifications{

    override fun send(message:String){

        println(" SMS: $message")

    }

}
class WhatsAppNotification2 : Notifications{

    override fun send(message:String){

        println(" WhatsApp: $message")

    }

}

//What Happens If Tomorrow Push Notification Is Added?
//Create New Class
class PushNotification : Notifications{

    override fun send(message:String){

        println(" Push: $message")

    }

}
// create factory class
object NotificationFactory{

    fun create(type:String): Notifications{

        return when(type){

            "email" -> EmailNotification2()

            "sms" -> SmsNotification2()

            "whatsapp" -> WhatsAppNotification2()

            "push" -> PushNotification()  //Update Only Factory ---The main() function does not change.

            else -> throw IllegalArgumentException("Unknown Notification")

        }

    }

}

//    --------------------------  Abstract Factory Pattern  ------------------------
//Abstract Factory creates a complete family of related objects that are
// designed to work together.

//First Understand the Problem
//Imagine you're developing an app that supports Light Theme and Dark Theme.
//Your UI has three components:
//-->Button
//-->TextField
//-->Card


//Without the Abstract Factory Pattern, you might write:

//   if (darkMode)
//    button = DarkButton()
//else
//    button = LightButton()
//
//if (darkMode)
//    textField = DarkTextField()
//else
//    textField = LightTextField()
//
//if (darkMode)
//    card = DarkCard()
//else
//    card = LightCard()

//Now imagine:
//20 UI components
//15 screens
//You'll repeat these if-else statements everywhere.

//Problem 1: Code Duplication
// Problem 2: Difficult Maintenance
// Problem 3: Mismatched UI

//----------- Real-Life Example (IKEA)-------------
//You go to IKEA and say:
//"I want a Modern Bedroom."
//They give you:
//✅ Modern Bed
//✅ Modern Wardrobe
//✅ Modern Table
//Everything matches.
//You don't receive:
//Modern Bed
//Vintage Table
//Classic Wardrobe

//The factory ensures everything belongs to the same family

// --------------solution---------------
// Step 1: Create Product Interfaces
interface Button {
    fun render()
}

interface TextField {
    fun render()
}

interface Card {
    fun render()
}
//Step 2: Create Light Theme Components
class LightButton : Button {
    override fun render() {
        println(" Light Button")
    }
}

class LightTextField : TextField {
    override fun render() {
        println(" Light TextField")
    }
}

class LightCard : Card {
    override fun render() {
        println(" Light Card")
    }
}
//Step 3: Create Dark Theme Components
class DarkButton : Button {
    override fun render() {
        println(" Dark Button")
    }
}

class DarkTextField : TextField {
    override fun render() {
        println("Dark TextField")
    }
}

class DarkCard : Card {
    override fun render() {
        println(" Dark Card")
    }
}
//Step 4: Create Abstract Factory
interface UIFactory {

    fun createButton(): Button

    fun createTextField(): TextField

    fun createCard(): Card

}
//Step 5: Light Theme Factory
class LightThemeFactory : UIFactory {

    override fun createButton() = LightButton()

    override fun createTextField() = LightTextField()

    override fun createCard() = LightCard()
}
    // Step 6: Dark Theme Factory
    class DarkThemeFactory : UIFactory {

        override fun createButton() = DarkButton()

        override fun createTextField() = DarkTextField()

        override fun createCard() = DarkCard()

    }
//   Step 7: Client Code
fun buildScreen(factory: UIFactory) {

    val button = factory.createButton()

    val textField = factory.createTextField()

    val card = factory.createCard()

    button.render()

    textField.render()

    card.render()

}
/// ----------------------- comparison--------------------------------
//| Factory Method               | Abstract Factory                     |
//| ---------------------------- | ------------------------------------ |
//| Creates one type of product  | Creates a family of related products |
//| Example: Notification        | Example: UI Theme                    |
//| Email, SMS, WhatsApp         | Button, TextField, Card              |
//| One product, many variations | Many products, one matching family   |
// --------------------------------------------------------------------
