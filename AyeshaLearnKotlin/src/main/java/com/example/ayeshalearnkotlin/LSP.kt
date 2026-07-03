package com.example.ayeshalearnkotlin
// before LSP
/*open class Seats {
    open fun bookSeat() {
        println("Seat booked")
    }
}
fun reserveSeat(seat: Seats) {
    seat.bookSeat()
}
fun main() {
    val seat = Seats()
    reserveSeat(seat)
}*/
open class Seats {
    open fun bookSeat() {
        println("Seat booked")
    }
}
class BusinessClass : Seats() {
    override fun bookSeat() {
        println("Business Class seat booked")
    }
}
class EconomyClass : Seats() {
    override fun bookSeat() {
        println("Economy Class seat booked")
    }
}
fun reserveSeat(seat: Seats) {
    seat.bookSeat()
}
fun main() {
    val business: Seats = BusinessClass()
    val economy: Seats = EconomyClass()
    reserveSeat(business)
    reserveSeat(economy)
}