//Telescoping Constructor Problem is the problem that occurs when a constructor has too
// many parameters, making object creation difficult to read, maintain, and use correctly.
// The Builder Pattern solves this by constructing the object step by step.

//methods
//--->Traditional method
//--->Apply{}
//--->DSL Builder

//traditional method:
//Traditional Builder → Use when you need required fields, validation, immutable objects,
// or you're designing a library/API.
class Notification private constructor(
    val title: String,
    val message: String,
    val icon: String,
    val sound: Boolean,
    val badgeCount: Int
) {

    class Builder(
        private val title: String,      // Required
        private val message: String     // Required
    ) {

        // Optional fields with default values
        private var icon: String = "ic_default"
        private var sound: Boolean = true
        private var badgeCount: Int = 0

        fun icon(value: String): Builder {
            this.icon = value
            return this
        }

        fun sound(value: Boolean): Builder {
            this.sound = value
            return this
        }

        fun badgeCount(value: Int): Builder {
            require(value >= 0) {
                "Badge count cannot be negative."
            }

            this.badgeCount = value
            return this
        }

        fun build(): Notification {
            return Notification(
                title,
                message,
                icon,
                sound,
                badgeCount
            )
        }
    }
}


//apply{}
//apply {} → Use for simple Kotlin objects, data classes, and quick initialization where
// validation isn't a concern.

data class notificationApply(

    var title: String = "",

    var message: String = "",

    var icon: String = "ic_default",

    var sound: Boolean = true,

    var badgeCount: Int = 0
)


// DSL
// Final immutable object
data class Student(
    val name: String,
    val age: Int,
    val city: String
)

// Builder class
class StudentBuilder {

    var name: String = ""
    var age: Int = 0
    var city: String = ""

    fun build(): Student {

        require(name.isNotBlank()) {
            "Name is required."
        }

        require(age > 0) {
            "Age must be greater than 0."
        }

        return Student(
            name,
            age,
            city
        )
    }
}
// DSL Function
fun student(
    block: StudentBuilder.() -> Unit
): Student {

    val builder = StudentBuilder()

    builder.block()

    return builder.build()
}


fun main() {
      // traditional method
    val notification = Notification.Builder(
        title = "New Message",
        message = "Ali sent a photo"
    )
        .icon("ic_message")
        .sound(true)
        .badgeCount(3)
        .build()

    println("Title      : ${notification.title}")
    println("Message    : ${notification.message}")
    println("Icon       : ${notification.icon}")
    println("Sound      : ${notification.sound}")
    println("BadgeCount : ${notification.badgeCount}")



    //apply{} method

        //with apply without apply we use notifications.title
    // apply means this.title however kotlin automatically understand the this operator so we
    // dont need to write this explicitly
        val notifications = notificationApply().apply {

            title = "New Message"

            message = "Ali sent a photo"

            icon = "ic_message"

            sound = true

            badgeCount = 3

        }

        println("Title      : ${notifications.title}")
        println("Message    : ${notifications.message}")
        println("Icon       : ${notifications.icon}")
        println("Sound      : ${notifications.sound}")
        println("BadgeCount : ${notifications.badgeCount}")


    //A DSL (Domain Specific Language) Builder is a Kotlin-style implementation of
// the Builder Pattern that uses a lambda with receiver (Builder.() -> Unit) to configure
// a builder object inside a block. After configuration, the build() function validates
// the data and creates the final immutable object. It makes code more readable, expressive, and
// Kotlin-idiomatic.

    //student {
    //
    //    name = "Ali"
    //
    //    age = 22
    //
    //    city = "Lahore"
    //}
    //        │
    //        ▼
    //block parameter
    //        │
    //        ▼
    //StudentBuilder created
    //        │
    //        ▼
    //builder.block()
    //
    //        │
    //        ▼
    //builder.name = "Ali"
    //
    //builder.age = 22
    //
    //builder.city = "Lahore"
    //        │
    //        ▼
    //builder.build()
    //        │
    //        ▼
    //Student Object


    val s1 = student {

        name = "Ali"

        age = 22

        city = "Lahore"

    }

    println(s1)


}


