package com.example.amanlearnkotlin


fun main() {
    // 1. Generic Class ka istemal (Int ke sath)
    val intContainer = Container<Int>(10)
    val intData = intContainer.getValue()
    println("Integer Data: $intData")

    // 2. Generic Class ka istemal (String ke sath)
    val stringContainer = Container<String>("Kotlin Generics")
    println("String Data: ${stringContainer.getValue()}")

    // 3. Generic Function ka istemal
    addEvent(25)
    addEvent("Meeting at 5 PM")
}

// GENERIC CLASS: 'T' yahan ek placeholder hai jo koi bhi type ho sakta hai
class Container<T>(var data: T) {
    fun setValue(newValue: T) {
        data = newValue
    }

    fun getValue(): T {
        return data
    }
}

// GENERIC FUNCTION: Ye function kisi bhi type ka argument le sakta hai
fun <T> addEvent(content: T) {
    println("Event added: $content")
}