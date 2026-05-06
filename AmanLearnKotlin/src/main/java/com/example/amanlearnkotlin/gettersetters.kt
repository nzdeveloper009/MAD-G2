package com.example.amanlearnkotlin

fun main() {
    val p1 = PersonGetter(nameParam = "aman", ageParam = 21)
    println(p1.age)   // Output: 21

    p1.age = 28
    println(p1.age)   // Output: 28

    p1.age = -12      // Output: Age cant be negative
    println(p1.age)   // Output: 28
}

class PersonGetter(nameParam: String, ageParam: Int) {
    var name: String = nameParam

    var age: Int = ageParam
        set(value) {
            if (value > 0) {
                field = value //use field keyword
            } else {
                println("Age cant be negative")
            }
        }

        get() {
            return field

        }
    var email:String=""
        get()=field
        set(values){
            field=values
        }

}
//by default getter and setters
