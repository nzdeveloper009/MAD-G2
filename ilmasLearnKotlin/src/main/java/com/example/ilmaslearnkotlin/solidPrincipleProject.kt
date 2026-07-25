package com.example.solidprinciples
//Problem Statement
//Design and develop a console-based Food Delivery System in Kotlin that allows
// users to browse restaurants, select food items, add them to a cart, and place orders.
// The system should support multiple payment methods, delivery partners, and notification services
// while following the SOLID principles to ensure the application is modular, maintainable, scalable, and easy to extend.



//The application should allow users to:
//-->View available restaurants and their menus.
//-->Calculate the total order amount.
//-->Choose from multiple payment methods such as Credit Card, Debit Card, JazzCash, EasyPaisa, and PayPal.
//-->Select a delivery partner such as Own Rider, Bykea, or InDrive.
//-->Receive order confirmations through Email, SMS, or Push Notifications.



//The system should be designed so that adding new payment methods, delivery partners, or notification
// channels requires minimal or no modification to the existing code, demonstrating the practical implementation
// of the SOLID principles.



data class FoodItem(
    val id: Int,
    val name: String,
    val price: Double
)
data class Restaurant(
    val id: Int,
    val name: String,
    val menu: MutableList<FoodItem>
)

class Cart {

    private val items = mutableListOf<FoodItem>()

    fun addItem(foodItem: FoodItem) {
        items.add(foodItem)
        println("${foodItem.name} added to cart.")
    }

    fun removeItem(id: Int) {
        items.removeIf { it.id == id }
    }

    fun getItems(): List<FoodItem> = items

    fun getTotal(): Double {
        return items.sumOf { it.price }
    }

    fun isEmpty(): Boolean {
        return items.isEmpty()
    }

    fun clear() {
        items.clear()
    }
}
data class Order(
    val id: Int,
    val items: List<FoodItem>,
    val total: Double,
    val address: String
)
class CartService(private val cart: Cart) {

    fun addFood(foodItem: FoodItem) {
        cart.addItem(foodItem)
    }

    fun removeFood(id: Int) {
        cart.removeItem(id)
    }

    fun showCart() {

        if (cart.isEmpty()) {
            println("Cart is empty.")
            return
        }

        println("\n===== CART =====")

        cart.getItems().forEach {
            println("${it.id}. ${it.name} - $${it.price}")
        }

        println("-----------------------")
        println("Total = $${cart.getTotal()}")
    }

    fun getCart() = cart
}

// payement module
interface PaymentMethod {
    fun pay(amount: Double)
}
class CreditCard : PaymentMethod {

    override fun pay(amount: Double) {
        println()
        println("========== PAYMENT ==========")
        println("Payment Method : Credit Card")
        println("Amount         : $$amount")
        println("Payment Successful")
    }
}
class DebitCard : PaymentMethod {

    override fun pay(amount: Double) {
        println()
        println("========== PAYMENT ==========")
        println("Payment Method : Debit Card")
        println("Amount         : $$amount")
        println("Payment Successful")
    }
}
class JazzCash : PaymentMethod {

    override fun pay(amount: Double) {
        println()
        println("========== PAYMENT ==========")
        println("Payment Method : JazzCash")
        println("Amount         : $$amount")
        println("Payment Successful")
    }
}
class EasyPaisa : PaymentMethod {

    override fun pay(amount: Double) {
        println()
        println("========== PAYMENT ==========")
        println("Payment Method : EasyPaisa")
        println("Amount         : $$amount")
        println("Payment Successful")
    }
}

class PayPal : PaymentMethod {

    override fun pay(amount: Double) {
        println()
        println("========== PAYMENT ==========")
        println("Payment Method : PayPal")
        println("Amount         : $$amount")
        println("Payment Successful")
    }
}
object PaymentFactory {

    fun create(choice: Int): PaymentMethod {

        return when (choice) {

            1 -> CreditCard()

            2 -> DebitCard()

            3 -> JazzCash()

            4 -> EasyPaisa()

            5 -> PayPal()

            else -> throw IllegalArgumentException("Invalid Payment Method")
        }
    }
}


// delivery module

interface DeliveryPartner {
    fun deliver(address: String)
}

class OwnRider : DeliveryPartner {

    override fun deliver(address: String) {

        println()
        println("========== DELIVERY ==========")
        println("Delivery Partner : Own Rider")
        println("Delivery Address : $address")
        println("Order is on the way.")
    }
}
class Bykea : DeliveryPartner {

    override fun deliver(address: String) {

        println()
        println("========== DELIVERY ==========")
        println("Delivery Partner : Bykea")
        println("Delivery Address : $address")
        println("Order is on the way.")
    }
}
class InDrive : DeliveryPartner {

    override fun deliver(address: String) {

        println()
        println("========== DELIVERY ==========")
        println("Delivery Partner : InDrive")
        println("Delivery Address : $address")
        println("Order is on the way.")
    }
}
object DeliveryFactory {

    fun create(choice: Int): DeliveryPartner {

        return when (choice) {

            1 -> OwnRider()

            2 -> Bykea()

            3 -> InDrive()

            else -> throw IllegalArgumentException("Invalid Delivery Partner")
        }
    }
}

// notification service
interface NotificationService {
    fun send(message: String)
}
class EmailNotification : NotificationService {

    override fun send(message: String) {

        println()
        println("========== NOTIFICATION ==========")
        println("Notification Type : Email")
        println("Message : $message")
        println("Email Sent Successfully")
    }
}
class SmsNotification : NotificationService {

    override fun send(message: String) {

        println()
        println("========== NOTIFICATION ==========")
        println("Notification Type : SMS")
        println("Message : $message")
        println("SMS Sent Successfully")
    }
}
class PushNotification : NotificationService {

    override fun send(message: String) {

        println()
        println("========== NOTIFICATION ==========")
        println("Notification Type : Push Notification")
        println("Message : $message")
        println("Push Notification Sent Successfully")
    }
}
object NotificationFactory {

    fun create(choice: Int): NotificationService {

        return when (choice) {

            1 -> EmailNotification()

            2 -> SmsNotification()

            3 -> PushNotification()

            else -> throw IllegalArgumentException("Invalid Notification Method")
        }
    }
}
fun main() {

    val kfc = Restaurant(
        1,
        "KFC",
        mutableListOf(
            FoodItem(1, "Zinger Burger", 8.0),
            FoodItem(2, "Fries", 3.0),
            FoodItem(3, "Pepsi", 2.0)
        )
    )

    val mcd = Restaurant(
        2,
        "McDonald's",
        mutableListOf(
            FoodItem(4, "Big Mac", 10.0),
            FoodItem(5, "McFlurry", 4.0),
            FoodItem(6, "Coke", 2.5)
        )
    )

    val restaurants = listOf(kfc, mcd)

    val cartService = CartService(Cart())

    while (true) {

        println()
        println("===== FOOD DELIVERY APP =====")
        println("1. View Restaurants")
        println("2. View Cart")
        println("3. Exit")

        when (readln().toInt()) {

            1 -> {

                println("\nRestaurants")

                restaurants.forEach {
                    println("${it.id}. ${it.name}")
                }

                print("Choose Restaurant: ")

                val restaurantId = readln().toInt()

                val restaurant = restaurants.first { it.id == restaurantId }

                println("\n${restaurant.name} Menu")

                restaurant.menu.forEach {
                    println("${it.id}. ${it.name} - $${it.price}")
                }

                print("Choose Food ID: ")

                val foodId = readln().toInt()

                val food = restaurant.menu.first { it.id == foodId }

                cartService.addFood(food)
            }

            2 -> {

                cartService.showCart()

                if (cartService.getCart().isEmpty())
                    continue

                println()
                println("Proceed to Checkout?")
                println("1. Yes")
                println("2. No")

                if (readln().toInt() == 1) {

                    println()
                    println("Choose Payment Method")
                    println("1. Credit Card")
                    println("2. Debit Card")
                    println("3. JazzCash")
                    println("4. EasyPaisa")
                    println("5. PayPal")

                    val paymentChoice = readln().toInt()

                    val payment = PaymentFactory.create(paymentChoice)

                    payment.pay(cartService.getCart().getTotal())

                    println()
                    println()

                    println("Choose Delivery Partner")

                    println("1. Own Rider")
                    println("2. Bykea")
                    println("3. InDrive")

                    val deliveryChoice = readln().toInt()

                    val deliveryPartner = DeliveryFactory.create(deliveryChoice)

                    print("Enter Delivery Address : ")

                    val address = readln()

                    deliveryPartner.deliver(address)


                    cartService.getCart().clear()
                    println()

                    println("Choose Notification Method")

                    println("1. Email")
                    println("2. SMS")
                    println("3. Push Notification")

                    val notificationChoice = readln().toInt()

                    val notification = NotificationFactory.create(notificationChoice)

                    notification.send("Your order has been placed successfully.")
                }
            }

            3 -> {
                println("Thank You!")
                return
            }

            else -> println("Invalid Option")
        }
    }
}


//                     Explanation

//1. SRP (Single Responsibility Principle)
//Applied in: CheckoutService
//Description:
//CheckoutService is responsible only for coordinating the checkout process.
// It doesn't contain the payment, delivery, or notification logic itself.





//2. OCP (Open/Closed Principle)
//Applied in: CheckoutService
//Description:
//You can add new payment methods, delivery partners, or notification
// services (e.g., Apple Pay, Foodpanda Rider, WhatsApp Notification) by
// creating new classes without modifying CheckoutService.




//3. LSP (Liskov Substitution Principle)
//Applied in: Interfaces
//PaymentMethod
//DeliveryPartner
//NotificationService
//Description:
//Any implementation (e.g., JazzCash, CreditCard, Bykea, OwnRider,
// EmailNotification, SmsNotification) can replace another without affecting
// CheckoutService.





//4. ISP (Interface Segregation Principle)
//Applied in: Interfaces
//PaymentMethod
//DeliveryPartner
//NotificationService
//Description:
//Each interface has only one specific responsibility, so classes implement
// only the methods they actually need.






//5. DIP (Dependency Inversion Principle)
//Applied in: CheckoutService
//class CheckoutService(
//    private val payment: PaymentMethod,
//    private val delivery: DeliveryPartner,
//    private val notification: NotificationService
//)
//Description:
//CheckoutService depends on abstractions (interfaces) instead of concrete
// classes (JazzCash, Bykea, EmailNotification), making the system flexible
// and loosely coupled.
