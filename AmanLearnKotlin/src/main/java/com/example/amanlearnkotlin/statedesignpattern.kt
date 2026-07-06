package com.example.amanlearnkotlin.com.example.amanlearnkotlin

// THE STATE INTERFACE
// This defines what actions can happen on our system.
// Every specific state must implement these methods.
interface GateState {
    fun insertCard(context: TransitGate)
    fun pressGate(context: TransitGate)
}

// THE CONCRETE STATES
// Each class handles the behavior for that specific state and manages transitioning to the next state.

class LockedState : GateState {
    override fun insertCard(context: TransitGate) {
        println("Gate System: Card accepted! Unlocking the turnstile now.")
        // Transitioning the context to the new state cleanly
        context.changeState(UnlockedState())
    }

    override fun pressGate(context: TransitGate) {
        println("Gate System: Cannot push. The turnstile is locked. Please insert a valid card first.")
    }
}

class UnlockedState : GateState {
    override fun insertCard(context: TransitGate) {
        println("Gate System: Card inserted, but turnstile is already unlocked. Card returned.")
    }

    override fun pressGate(context: TransitGate) {
        println("Gate System: Pushed successfully. Passenger passed through. Locking gate again.")
        // Resetting back to the default locked state
        context.changeState(LockedState())
    }
}

// THE CONTEXT CLASS
// This is the main class exposed to the application layer.
// It keeps track of the current state reference and delegates the work.
class TransitGate {

    // We start off in a default Locked state
    private var currentState: GateState = LockedState()

    fun changeState(newState: GateState) {
        this.currentState = newState
    }

    // The context actions just hand over the responsibility to the current state object
    fun insertCard() {
        currentState.insertCard(this)
    }

    fun pushTurnstile() {
        currentState.pressGate(this)
    }
}

// Running our dynamic state management execution runtime
fun main() {
    val metroGate = TransitGate()

    // Testing actions while the gate is in its initial locked state
    println("User Action: Trying to walk through without paying.")
    metroGate.pushTurnstile()

    // Processing payment state shift
    println("User Action: Swiping travel card.")
    metroGate.insertCard()

    // Passing through the open gate
    println("User Action: Walking through the turnstile arm.")
    metroGate.pushTurnstile()

    // Trying to pass through immediately again without a second payment
    println("User Action: Next passenger tries to rush through.")
    metroGate.pushTurnstile()
}