package com.learning.learnkotlin

//Liskov , object of superclass should be replaceable with object of its
//subclasses without altering the describe properties of program.
open class BankAccount(var balance: Double = 0.0) {
    open fun deposit(amount: Double) {
        balance += amount
        println("Deposited: $amount, New Balance: $balance")
    }
}

// 2. Interface (Sirf un accounts ke liye jo withdraw allow karte hain)
interface Withdrawable {
    fun withdraw(amount: Double)
}

// 3. Savings Account (Dono kaam kar sakta hai)
class SavingsAccount : BankAccount(), Withdrawable {
    override fun withdraw(amount: Double) {
        if (balance >= amount) {
            balance -= amount
            println("Withdrawn: $amount, Remaining Balance: $balance")
        } else {
            println("Insufficient balance!")
        }
    }
}

// 4. Fixed Deposit Account (Sirf deposit allow karta hai, withdraw nahi)
class FixedDepositAccount : BankAccount() {
    // Isme withdraw ka method implement hi nahi hoga, so no exception!
    override fun deposit(amount: Double) {
        // FD mein aksar aik hi baar deposit hota hai
        super.deposit(amount)
    }
}

// Usage Example
fun main() {
    val savings: Withdrawable = SavingsAccount()
    savings.withdraw(100.0)

    val fd = FixedDepositAccount()
    fd.deposit(5000.0)
    // fd.withdraw(100.0) // Error: Ye method yahan available hi nahi hai
}