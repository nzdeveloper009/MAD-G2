//state pattern
//State Design Pattern is a Behavioral Design Pattern that allows an object to
// change its behavior when its internal state changes. Instead of using large
// if-else or switch statements, each state is represented by a separate class or object.

         //State Changes
        //      ↓
        // Behavior Changes

//example:

//Media Player

//Stopped → Play button → Start Music
//Playing → Play button → Pause Music
//Paused → Play button → Resume Music

//before state pattern
class MediaPlayer {

    var state = "STOPPED"

    fun pressPlay() {
        if (state == "STOPPED") {
            println("Start Music")
        } else if (state == "PLAYING") {
            println("Pause Music")
        } else if (state == "PAUSED") {
            println("Resume Music")
        }
    }
}

//   ----- problems------
//1---> when we have to add new state then we have to change all code
//2----> multiple if else if difficult to understand
//3---> violation of open/closed principle

///  ------  solution -------
// state pattern
// State Interface
interface UserState {
    fun viewProfile(user: User)
}

// Concrete State 1


///  --- approaches-----
//  Level 1: Classic GoF implementation (Interface + State Classes)
object GuestState : UserState {

    override fun viewProfile(user: User) {
        println("Access Denied. Please Login.")

        // Change state after login
        user.state = LoggedInState
        println("User Logged In.")
    }
}

// Concrete State 2
object LoggedInState : UserState {

    override fun viewProfile(user: User) {
        println("Welcome ${user.name}. Full Profile Opened.")
    }
}

// Context
class User(
    val name: String,
    var state: UserState
) {

    fun clickProfile() {
        state.viewProfile(this)
    }
}



//   Level 2: Enum-based implementation
// enum class is used where number of states are constant/fixed and simple.
//  example:   traffic lights---- red,green,yellow
// but in state pattern we have to implement the behaviors according to the states

enum class UserStatus {

    GUEST {
        override fun view(user: UserAccount) {
            println("Showing Guest Preview for ${user.username}")
        }
    },

    MEMBER {
        override fun view(user: UserAccount) {
            println("Showing Full Profile for ${user.username}")
        }
    },

    ADMIN {
        override fun view(user: UserAccount) {
            println("Showing Admin Dashboard for ${user.username}")
        }
    };

    abstract fun view(user: UserAccount)
}

class UserAccount(
    val username: String,
    var status: UserStatus
) {

    fun openProfile() {
        status.view(this)
    }
}




//  Level 3: Advanced Kotlin DSL/Lambda-based implementation

class SmartUser(
    val id: String,
    var state: SmartState
) {

    fun openProfile() {
        state.onOpen(this)
    }
}

enum class SmartState(
    val onOpen: SmartUser.() -> Unit
) {

    LOCKED({

        println("Please unlock account $id first.")

    }),

    UNLOCKED({

        println("Welcome $id")

    }),

    PREMIUM({

        println("Premium Dashboard for $id")

    })
}
//    DSL ka concept SmartUser.() -> Unit mein use hua hai. Ye Lambda with Receiver hai.
//    Is wajah se lambda ke andar SmartUser ka object automatically this ban jata hai aur
//    hum user.id ya it.id ki bajaye seedha id likh sakte hain. Isi Kotlin DSL style ki
//    wajah se code concise aur readable ban jata hai.



// sealed class(modern way)
//Perfect for states holding different data (e.g., Success data vs Error exception).
// Allows exhaustive when blocks while keeping logic clean.

//Enum = Sirf state ka naam.
//Sealed Class = State + us state ka apna data.


sealed class ResultState {

    object Loading : ResultState()

    data class Success(val data: String) : ResultState()

    data class Error(val message: String) : ResultState()
}
fun show(state: ResultState) {

    when(state) {

        is ResultState.Loading ->
            println("Loading...")

        is ResultState.Success ->
            println(state.data)

        is ResultState.Error ->
            println(state.message)
    }
}


// Client  GoF  implementation
fun main() {

    val user = User("Almas", GuestState)

    user.clickProfile()

    println()

    user.clickProfile()

println("------------------------------------------------------------")
    //enum implementation
    val users = UserAccount("Almas", UserStatus.GUEST)

    users.openProfile()

    users.status = UserStatus.MEMBER

    users.openProfile()

    users.status = UserStatus.ADMIN

    users.openProfile()

    println("------------------------------------------------------------")
    //dsl

    val user1 = SmartUser("Almas", SmartState.LOCKED)

    user1.openProfile()

    user1.state = SmartState.UNLOCKED

    user1.openProfile()

    user1.state = SmartState.PREMIUM

    user1.openProfile()
    println("------------------------------------------------------------")

//  sealed class
        val state1 = ResultState.Loading

        val state2 = ResultState.Success("Welcome Almas")

        val state3 = ResultState.Error("No Internet")

        show(state1)

        show(state2)

        show(state3)



}