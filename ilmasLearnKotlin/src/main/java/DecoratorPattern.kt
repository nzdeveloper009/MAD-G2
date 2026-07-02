// what is decorator pattern
//Decorator Pattern is a structural design pattern that allows us to add new behavior to an
// existing object dynamically without modifying its original source code.

//Take an existing object, wrap it with another object, and add a new feature without
// changing the original object.

//Think of it like wrapping a gift.
//          Gift
//           ↓
//     Wrap with Gift Paper
//           ↓
//      Wrap with Ribbon
//           ↓
//      Wrap with Greeting Card

//The original gift stays the same. Each wrapper only adds a new feature.



// ---------First Understand the Problem---------
//Suppose you have a simple logger.
class ConsoleLogger {
   fun log(message: String) {
       println(message)
   }
}

//   It prints:
//    Hello World

//Now your client says:

//---->Add timestamp.
//   Output should become:
//    10:30:20 Hello World

//Then the client says:
//--->Add thread name.
//main 10:30:20 Hello World

//Then:
//--->Add Debug Info
//DEBUG main 10:30:20 Hello World

//Then:
//--->Add User ID
//User-15 DEBUG main 10:30:20 Hello World


//-----------Without Decorator----------
//You'll start creating classes like:

//          ConsoleLogger
//               ↓
//            TimeLogger
//               ↓
//            ThreadLogger
//                ↓
//             DebugLogger
//                 ↓
//            TimeThreadLogger
//                  ↓
//               TimeDebugLogger
//                   ↓
//            TimeThreadDebugLogger

//Soon you'll have dozens of classes. This is called the Class Explosion Problem.
//The number of classes grows rapidly.
//  -------------solution----------------------
//Decorator Pattern solves this problem by wrapping objects instead of creating a
// new class for every combination

// -------------methods-------------------
// ----------1- composition over inheritence--------------------------

// composition means:
   //     one class contains an object of another class.
//        Instead of inheriting, it uses another object.

interface Coffee {

    fun cost(): Int

}
class BasicCoffee : Coffee {

    override fun cost(): Int {

        return 100

    }

}
//3. Decorator Method
abstract class CoffeeDecorator(

    val coffee: Coffee

) : Coffee

class MilkDecorator(

    coffee: Coffee

) : CoffeeDecorator(coffee) {

    override fun cost(): Int {

        return coffee.cost() + 20

    }

}
class SugarDecorator(

    coffee: Coffee

) : CoffeeDecorator(coffee) {

    override fun cost(): Int {

        return coffee.cost() + 10

    }

}
class ChocolateDecorator(

    coffee: Coffee

) : CoffeeDecorator(coffee) {

    override fun cost(): Int {

        return coffee.cost() + 30

    }

}



//    ----------- 2- Modern Kotlin Way(Functional Decorator)--------------
  //Every feature required a new class.
//Kotlin provides a cleaner way.
//   step 1: create a functional interface

//What is fun interface?
//A fun interface (functional interface) is an interface with only one abstract function.
fun interface Logger {

    fun log(message: String)

}
//Since it has only one method, Kotlin lets us create it using a lambda.

// step2:create a base logger
val logger = Logger {

    println(it)

}
//Kotlin internally banati hai
//val logger = object : Logger {
//    override fun log(message: String) {
//        println(message)
//    }
//}
//Dono bilkul same hain.
//Bas pehla modern syntax hai.


//Step 3: Extension Function
//Now we add a timestamp.
fun Logger.withTimeStamp(): Logger {

    return Logger {

        val time = System.currentTimeMillis()

        this.log("$time : $it")

    }

}
fun Logger.withThreadName(): Logger {

    return Logger {

        val thread = Thread.currentThread().name

        this.log("[$thread] $it")

    }

}


fun main(){
    var coffee: Coffee = BasicCoffee()

    coffee = MilkDecorator(coffee)

    coffee = SugarDecorator(coffee)

    coffee = ChocolateDecorator(coffee)

    println( "price of coffee: ${coffee.cost()}")
    // what happens here:
    //   BasicCoffee
    //     ↓
    //  MilkDecorator
    //     ↓
    //  SugarDecorator
    //     ↓
    //  ChocolateDecorator
    //     ↓
    //  cost()
    println("----------------------------------------------------------------------")
    println("modern kotlin way")
    val logger = Logger {

        println(it)

    }
        .withTimeStamp()
        .withThreadName()
    logger.log("Hello")

    // runtime decorator
    val debugMode = true    // ← this could come from config/user setting

    // Decoration happens AT RUNTIME based on condition
    val finalLogger =
        if (debugMode)
            logger.withThreadName()   // debug ON  → add thread info
        else
            logger                    // debug OFF → plain logger

    finalLogger.log("App Started")

}

