package com.example.lib
// three main methods 1) Traditional Method
class Notification private constructor(
    val title: String,
    val message: String,
    val icon: String,
    val sound:Boolean,
    val badgecount: Int
){
    class Builder(private val title: String, private val message: String//Requried fields
    ){
        // Optional fields with default values
                  private var icon: String = "ic_default"
                  private var sound: Boolean = true
                  private var badgeCount: Int = 0
        // Setter functions
        fun icon(value: String): Builder {
        this.icon = value
        return this
    }
    fun sound(value: Boolean): Builder {
        this.sound = value
        return this
    }
        fun badgeCount(count: Int): Builder {
            if (count < 0) throw Exception("Negative badge can't count !")
            this.badgeCount = count
            return this
        }
        // build made final object
        fun build(): Notification {
            return Notification(title, message, icon, sound, badgeCount)
            println("Object create succfully!")
        }
    }
}
/*fun main(){
    val notifications= Notification.Builder("NEW Message","Amna send a pick")
        .icon("ic_message")
        .sound(true)
        .badgeCount(4)
        .build()
}*/
// 2) apply{}
data class Notifications(
    var title: String="",
    var message: String="",
    var icon: String="ic_default",
    var sound:Boolean=true,
    var badgecount: Int=0

)
/*fun main(){
    val notifi= Notifications().apply {
        title = "New Message!"
        message = "Ali sent a photo"
        icon = "ic_message"
        sound = true
        badgecount = 3
    }
}*/
// 3) DSL method

// Final class
data class Notificationss(
    val title: String,
    val message: String,
    val icon: String,
    val sound: Boolean,
    val badgeCount: Int,
    val targetScreen: String
)

// Builder class
class NotificationBuilder {
    var title: String = ""
    var message: String = ""
    var icon: String = "ic_default"
    var sound: Boolean = true
    var badgeCount: Int = 0
    var targetScreen: String = "HomeScreen"
    fun build(): Notificationss{
        require(title.isNotEmpty()) { "Title dena zarori hai!" }
        require(message.isNotEmpty()) { "Message dena zarori hai!" }
        return Notificationss(title, message, icon, sound, badgeCount, targetScreen)
    }
}

// DSL function
fun notification(block: NotificationBuilder.() -> Unit): Notificationss {
    val builder = NotificationBuilder()
    builder.block()
    return builder.build()
}
fun main() {
    val newNotification = notification {
        title = "Meeting Reminder"
        message = "10 AM meeting hai team ke saath"
        icon = "ic_calendar"
        sound = false
        badgeCount = 1
        targetScreen = "CalendarScreen"
    }
    println("Title: ${newNotification.title}")
    println("Message: ${newNotification.message}")
    println("Icon: ${newNotification.icon}")
    println("Sound: ${newNotification.sound}")
    println("Badge: ${newNotification.badgeCount}")
    println("Screen: ${newNotification.targetScreen}")
}

