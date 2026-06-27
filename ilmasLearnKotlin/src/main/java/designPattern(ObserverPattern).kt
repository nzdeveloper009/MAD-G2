import kotlin.properties.Delegates
// what is design patterns?

    // design pattern is the ready-made,tested solution to a commonly repeating problems in software development.
    // design pattern is not a code it is a blueprint of the code



   // ->  example:

    // if you need a hammer a nail you use a hammer. you dont create a new tool every time.
    // similarly in programming you dont invent a new solution for every common problem. instead
    // you use the most suitable Design pattern that has already been created and tested.


    // -> why we use them?
    // reuseability,readability,maintainable,scalable


    //->  types of patterns
    //1.observer pattern(traditional,delegates,lambda-based,API Flow)
    //2.Builder design pattern
    //3.State design Pattern
    //4.Strategy Design Pattern
    //5.factory Pattern
    //6.Decorator Design Pattern


// observer pattern
 //When one object changes, all the objects connected to it are automatically notified. This is called the Observer Pattern.
//Example:
//A message is sent in a WhatsApp group.
//All group members receive a notification automatically.
//This is how the Observer Pattern works.

 //Imagine you are in a WhatsApp group.
 //Someone sends a message: "Meeting at 3 PM"
 //Immediately, three things happen automatically:
 //Your phone buzzes (vibrates).
 //A notification pops up on your screen.
 //You don't even have to open the app or check it manually to know what's happening.

 //The Roles
 //Subject (The WhatsApp Group): This is the core object. When its state changes
 // (like a new message arrives), it holds the master list of everyone who needs to know.

 //Observers (The Group Members): These are the people or devices waiting for updates.
 // They don't constantly check for news; they just wait to be told.


 //The Actions
 //subscribe() (Join Group): A new member joins the group. The Subject adds them to its notification list.
 //unsubscribe() (Leave Group): A member leaves. The Subject removes them so they stop getting alerts.
 //notify() (Send Notification): The exact moment a message is sent, the Subject loops through its list and
 // instantly alerts every Observer.


 //The Core Rule: One subject changes --> all observers automatically react. You don't ask for updates;
 // the system pushes them to you.
    fun main(){

     //traditional method of observer pattern
     val channel = YoutubeChannel()

     val user1 = YoutubeUser("Ilmas")
     val user2 = YoutubeUser("Ayesha")

     channel.addSubscriber(user1)
     channel.addSubscriber(user2)

     channel.uploadVideo("Kotlin Tutorial")


     // Delegates
     val userList = mutableListOf(
         PhoneUser("Maryam"),
         PhoneUser("Hadi")
     )

     var temperature: Int by Delegates.observable(20) { _, old, new ->

         println("Changed: ${old}°C -> ${new}°C")

         for(user in userList){
             user.update(new)
         }
     }

     temperature = 35
     temperature= 40





     // lambda based
     // no interface ,no observer class instead od observer class lambda functions used
       // small code size
         val observers = mutableListOf<(Int) -> Unit>()

         observers.add { temp ->
             println("Samsung Display: ${temp}°C")
         }

         observers.add { temp ->
             println("Lenovo Desktop: ${temp}°C")
         }

         observers.add { temp ->
             println("Orient TV: ${temp}°C")
         }

         fun tempUpdate(newTemp: Int) {
             for (observer in observers) {
                 observer(newTemp)
             }
         }

         tempUpdate(35)


     // API-Flow
     //API Allows an application to request data from server and receive a response

     // example:  customer-->Waiter(API)-->Kitchen




     // Fake API Response
     // -----------------------------

     val fakeApiJson = """{"city":"Lahore","temperature":38}"""

     val apiTemp = fakeApiJson
         .substringAfter("\"temperature\":")
         .substringBefore("}")
         .trim()
         .toInt()

     println("\nAPI Returned Temperature: ${apiTemp}°C\n")

     // -----------------------------
     // Feed API Data to all Methods
     // -----------------------------

     // Delegates
     temperature = apiTemp

     println()

     // Lambda
     tempUpdate(apiTemp)

     println()

     // Traditional
     channel.uploadVideo("${apiTemp}°C")
}






 //traditional method of observer pattern(most classic and structured method)
 //pros: run time add/remove,one event can handle multiple observers ,loose coupling
 //cons: manually handle,memory leak,a lot of boiler code
 interface Subscriber {
     fun update(title: String)
 }

 class YoutubeUser(val name: String) : Subscriber {
     override fun update(title: String) {
         println("$name got notification: $title")
     }
 }

 class YoutubeChannel {

     private val subscribers = mutableListOf<Subscriber>()

     fun addSubscriber(s: Subscriber) {
         subscribers.add(s)
     }

     fun uploadVideo(title: String) {
         for (s in subscribers) {
             s.update(title)
         }
     }
 }

 // Delegates
//Delegates.observable is a built-in feature in Kotlin. When a variable's value changes,
// it automatically runs a block of code (a lambda). Inside this block, we notify the observers.
// Because this happens automatically, you do not need to call a notify() function manually.

 class PhoneUser(val name: String) {
     fun update(temp: Int) {
         println("$name got temp: ${temp}°C")
     }
 }
