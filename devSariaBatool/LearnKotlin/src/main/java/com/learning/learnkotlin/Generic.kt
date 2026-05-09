package com.learning.learnkotlin

class IntContainer(var data: Int) {
    fun setValue(value: Int) {
        data = value
    }
    fun getValue(): Int {
        return data
    }
}

class StringContainer(var data: String) {
    fun setValue(value: String) {
        data = value
    }
    fun getValue(): String {
        return data
    }
}


class Container<T>(var data: T) {
    fun setValue(value: T) {
        data = value
    }
    fun getValue(): T {
        return data
    }
}


fun addNumbers(vararg values: Int) {
    var sum = 0
    for (i in values) {
        sum += i
    }
    println("Sum is: $sum")
}

fun main() {

    val intObj = IntContainer(5)
    println("IntContainer Value: ${intObj.getValue()}")


    val genericInt = Container<Int>(10)
    println("Generic Int Value: ${genericInt.getValue()}")


    val genericString = Container<String>("Cheezy Code")
    println("Generic String Value: ${genericString.getValue()}")


    addNumbers(1, 2, 3, 4, 5)
    addNumbers(10, 20)
    addNumbers(1, 1, 1, 1, 1, 1, 1)
}