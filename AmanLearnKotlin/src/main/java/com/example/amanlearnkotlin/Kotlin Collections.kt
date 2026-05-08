package com.example.amanlearnkotlin

fun main() {
    // ---------------------------------------------------------
    // 1. LISTS (Ordered elements)
    // ---------------------------------------------------------

    // Immutable List (Sirf read kar sakte hain, badal nahi sakte)
    val readOnlyList = listOf("Kotlin", "Java", "Python")
    println("Immutable List: $readOnlyList")
    // readOnlyList.add("Dart") // Ye error dega

    // Mutable List (Add, Remove aur Update kar sakte hain)
    val techStack = mutableListOf("Android Studio", "IntelliJ")
    techStack.add("VS Code")         // Naya item add karna
    techStack.remove("IntelliJ")    // Item remove karna
    techStack[0] = "Android Pro"    // Update karna
    println("Mutable List: $techStack")


    // ---------------------------------------------------------
    // 2. MAPS (Key-Value Pairs)
    // ---------------------------------------------------------

    // Immutable Map (Read-only)
    val config = mapOf("Theme" to "Dark", "FontSize" to "14")
    println("Immutable Map: $config")

    // Mutable Map (Data add/change karne ke liye)
    val userScores = mutableMapOf<String, Int>()
    userScores["Aman"] = 95
    userScores["Ali"] = 88
    userScores.put("Sara", 92) // .put() bhi use kar sakte hain

    // Map se data nikalna
    val amanScore = userScores["Aman"]
    println("Aman's Score: $amanScore")

    // Map par loop chalana
    println("--- All User Scores ---")
    for ((name, score) in userScores) {
        println("User: $name, Score: $score")
    }
}