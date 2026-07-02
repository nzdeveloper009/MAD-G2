package com.example.ayeshalearnkotlin
//before SRP
/*class Order {
    fun order(orderId: Int) {}
    fun bill(orderId: Int, billId: Int) {}
    fun saveToDatabase(orderId: Int) {}
    fun login() {}
}*/
//After SRP
class Order(var orderId: Int, var item: String, var quantity: Int) {
    fun displayOrder() {
        println("Order ID: $orderId")
        println("Item: $item")
        println("Quantity: $quantity")
    }
}
class Bill(var billId: Int, var orderId: Int, var totalAmount: Double) {
    fun generateBill() {
        println("Bill ID: $billId")
        println("Total Amount: Rs. $totalAmount")
    }
}
class Login(var username: String, var password: String) {
    fun login() {
        println("Login Successful")
    }
}
class Database {
    fun saveOrder(orderId: Int) {
        println("Order $orderId saved to database")
    }
}
fun main() {
    val login = Login("admin", "1234")
    login.login()
    val order = Order(1, "Burger", 2)
    order.displayOrder()
    val bill = Bill(101, 1, 500.0)
    bill.generateBill()
    val database = Database()
    database.saveOrder(order.orderId)
}