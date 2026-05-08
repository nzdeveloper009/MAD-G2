package com.example.amanlearnkotlin


fun main() {
    val p1 = UserAccount(1, "Aman")
    val p2 = UserAccount(1, "Aman")

    // 1. toString(): Automatic formatting milta hai
    println(p1) // Output: UserAccount(id=1, name=Aman)

    // 2. Equals: Data check karta hai (Address nahi)
    if (p1 == p2) {
        println("Both are equal")
    }

    // 3. Copy: Ek naya object banane ke liye kuch changes ke sath
    val p3 = p1.copy(id = 2)
    println(p3)

    // 4. Destructuring: Data ko alag alag variables mein nikalna
    val (myId, myName) = p1
    println("Id is $myId and Name is $myName")
}

// Data class ke liye 'data' keyword aur constructor mein kam se kam ek val/var lazmi hai
data class UserAccount(val id: Int, val name: String)