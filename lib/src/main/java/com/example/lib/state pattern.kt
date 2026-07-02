package com.example.lib
//state pattern has three main parts
//1. context -> it don't do anything it has three things state-> a variable that store current state
// setstate(), request()
// 2. state interface
//3.concrete state -> class that implement interface
 interface Userstate{// state interface
    fun viewprofile(user:User)
 }
object anomymousState: Userstate{
    override fun viewprofile(user: User) {
        println(" access denied fisrt login")
    }

}
object loginState: Userstate{//concrte class
    override fun viewprofile(user: User) {
        println(" Welcom  here is your login page")
    }

}
class User(val name: String){// context
    var state: Userstate= anomymousState // set by default
    fun clickProfile(){
        state.viewprofile(this)
    }
}
/*fun main() {
    val sanila = User("Sanila")
    sanila.clickProfile()
    sanila.state = loginState
    sanila.clickProfile()

}*/
// Transitions methods
//1.state itself trigger Transition
object AnomymousState: Userstate{
    override fun viewprofile(user: User) {
        println(" access denied fisrt login")
        sanila.state= loginState
    }}
//2. context handle Transition

//Using Enum class
enum class userstate(val onAction :(UserAccount)-> Unit){
    GUEST ({user->
        println(" Showing Guest")
    }),
    MEMBER({user-> println(" Showing Member")})
}
class UserAccount(val username: String) {
    var status = userstate.GUEST   // default state

    fun view() {
        status.onAction(this)
    }
}

/*fun main() {
    val user = UserAccount("Sanila")
    println("--- Guest State ---")
    user.view()
    user.status = userstate.MEMBER
    println("\n--- Member State ---")
    user.view()
}*/
 // USING DSL ( lambda with reciver)
// Enum class using lambda with receiver: SmartUser.() -> Unit
 enum class SmartState(val onOpen: SmartUser.() -> Unit) {
     LOCKED({
         // 'this' here automatically refers to SmartUser, so direct access is possible
         showToast("Please unlock account $id first.")
     }),
     UNLOCKED({
         openSettings()
     }),
     // added a new state, notice how clean this is
     SUSPENDED({
         showToast("Account $id is suspended. Contact support.")
     })
 }
// Context class  contains the functions being called directly inside each state
class SmartUser(val id: String) {
    var state: SmartState = SmartState.LOCKED

    // These are the functions being called "directly" inside the state lambdas
    fun showToast(message: String) {
        println("TOAST: $message")
    }
    fun openSettings() {
        println("Opening settings screen for user $id...")
    }
    fun open() {
        state.onOpen(this)   // passing 'this' (SmartUser) as the receiver
    }
}
fun main() {
    val smartUser = SmartUser("SU101")
    // Step 1: currently in Locked state
    println("--- Locked State ---")
    smartUser.open()
    // Step 2: user unlocks the account
    smartUser.state = SmartState.UNLOCKED
    println("\n--- Unlocked State ---")
    smartUser.open()
    // Step 3: account gets suspended
    smartUser.state = SmartState.SUSPENDED
    println("\n--- Suspended State ---")
    smartUser.open()
}