package com.example.ayeshalearnkotlin.getter
    fun main() {
        val p = person(20)

        println(p.name ) // getter runs here
        println(p.age)
        p.password="1234"
    }
class person(val age:Int){

        var name: String = "Ayesha"
            //getter
            get() = field.uppercase()
    var password: String = ""
        //setter
        set(value) {
            if (value.length >= 6) {
                field = value
            } else {
                println("Password must be at least 6 characters")
            }
        }
}