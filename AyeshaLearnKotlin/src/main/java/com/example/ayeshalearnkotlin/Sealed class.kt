package com.example.ayeshalearnkotlin
// Sealed class: restricts all possible types of shapes
// Only Pentagon and Hexagon are allowed subclasses
sealed class Shapee {

    // Data class representing a Pentagon
    // 'side' stores the length of one side
    data class Pentagon(val side: Double) : Shapee()

    // Data class representing a Hexagon
    // 'side' stores the length of one side
    data class Hexagon(val side: Double) : Shapee()
}

fun main() {

    // Variable of type Shapee can hold any subclass object (Pentagon or Hexagon)
    val shape: Shapee = Shapee.Hexagon(6.0)

    // 'when' expression checks the actual type of shape at runtime
    // Smart casting is applied automatically
    when (shape) {

        // If shape is Pentagon, access its 'side' property
        is Shapee.Pentagon ->
            println("Pentagon side: ${shape.side}")

        // If shape is Hexagon, access its 'side' property
        is Shapee.Hexagon ->
            println("Hexagon side: ${shape.side}")
    }
}