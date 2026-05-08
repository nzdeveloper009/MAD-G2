package com.example.amanlearnkotlin


fun main() {
    // 1. Non-Nullable Type (Ismein null nahi aa sakta)
    var name: String = "Aman"
    // name = null // Ye error dega

    // 2. Nullable Type (Question mark '?' lagane se null allow hota hai)
    var gender: String? = null
    gender = "Male"
    gender = null

    // 3. Safe Call Operator (?.)
    // Agar gender null hai to ye line crash nahi hogi, sirf 'null' return karegi
    println(gender?.uppercase())

    // 4. Elvis Operator (?:)
    // Agar gender null hai to default value "NA" use hogi
    val displayGender = gender ?: "NA"
    println(displayGender)

    // 5. Let Function (Safe calls ke sath use hota hai)
    gender?.let {
        // Ye block sirf tab chalega jab gender null NAHI hoga
        println("Line 1: $it")
        println("Line 2: $it")
    }

    // 6. Not-Null Assertion (!!)
    // Ye tab use hota hai jab aap 100% sure hon ke value null nahi hogi.
    // Agar null hui to program crash ho jayega (NullPointerException)
    // println(gender!!.uppercase())
}