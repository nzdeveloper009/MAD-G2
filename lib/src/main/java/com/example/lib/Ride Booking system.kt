package com.example.lib

//PROBLEM STATEMENT:
// Design and develop a console based Smart Ride Booking System in Kotlin that
// allows users to enter pickup/dropoff locations, choose vehicle categories,
// apply discount promo codes, select drivers, choose payment methods, and receive
// ride confirmation notifications.
// The system must be modular, scalable, and follow SOLID principles so that adding
// new vehicle types, payment methods, or notification channels requires minimal
// or no modification to existing core logic.

// SCOPE OF THE PROJECT
// The application allows users to:
// 1. Enter ride details (Pickup location, dropoff location, and distance in KM).
// 2. Select from multiple vehicle options (Standard Car, Premium Car, Bike, Rickshaw).
// 3. Apply promo codes (e.g., 'SAVE10', 'FIRST20') to calculate discounts automatically.
// 4. Match and view available nearby drivers based on rating/distance.
// 5. Choose flexible payment options (Cash, Credit/Debit Card, JazzCash, EasyPaisa).
// 6. Receive booking receipts via Push Notifications, SMS, or Email.
// 7. Interactive main menu loop for smooth user experience.


// 1. DATA MODELS
// Single Responsibility Principle (SRP):

data class Passenger(
    val id: Int,
    val name: String,
    val phone: String
)
data class Location(
    val pickupPoint: String,
    val dropLocation: String,
    val distanceInKm: Double
)

data class Driver(
    val id: Int,
    val name: String,
    val vehicleName: String,
    val rating: Double
)

data class RideReceipt(
    val rideId: String,
    val passenger: Passenger,
    val location: Location,
    val totalFare: Double,
    val driver: Driver
)

// 2. FARE & DISCOUNT CALCULATOR (SRP)
class FareCalculator {
    fun calculateBaseFare(distanceKm: Double, ratePerKm: Double): Double {
        return distanceKm * ratePerKm
    }

    fun applyDiscount(amount: Double, promoCode: String): Double {
        return when (promoCode.uppercase()) {
            "SAVE10" -> amount * 0.90 // 10% Off
            "FIRST20" -> amount * 0.80 // 20% Off
            else -> amount // No discount
        }
    }
}

// 3. VEHICLE & FARE STRATEGY (OCP + LSP)
interface VehicleType {
    val ratePerKm: Double
    fun getVehicleCategory(): String
}

class StandardCar : VehicleType {
    override val ratePerKm: Double = 60.0
    override fun getVehicleCategory(): String = "Standard Car (AC Sedan)"
}

class PremiumCar : VehicleType {
    override val ratePerKm: Double = 120.0
    override fun getVehicleCategory(): String = "Premium Luxury Car"
}

class BikeRide : VehicleType {
    override val ratePerKm: Double = 30.0
    override fun getVehicleCategory(): String = "Motorbike Ride"
}

class RickshawRide : VehicleType {
    override val ratePerKm: Double = 40.0
    override fun getVehicleCategory(): String = "Auto Rickshaw"
}

object VehicleFactory {
    fun create(choice: Int): VehicleType {
        return when (choice) {
            1 -> StandardCar()
            2 -> PremiumCar()
            3 -> BikeRide()
            4 -> RickshawRide()
            else -> throw IllegalArgumentException("Invalid Vehicle Choice!")
        }
    }
}

// 4. DRIVER MATCHING MODULE (OCP + LSP)
interface DriverMatchingStrategy {
    fun matchDriver(availableDrivers: List<Driver>): Driver
}

class NearestDriverStrategy : DriverMatchingStrategy {
    override fun matchDriver(availableDrivers: List<Driver>): Driver {
        println("[Matching Engine] Finding the nearest available driver...")
        return availableDrivers.first()
    }
}

class TopRatedDriverStrategy : DriverMatchingStrategy {
    override fun matchDriver(availableDrivers: List<Driver>): Driver {
        println("[Matching Engine] Finding top-rated driver for high quality ride...")
        return availableDrivers.maxByOrNull { it.rating } ?: availableDrivers.first()
    }
}


// 5. PAYMENT MODULE (OCP + LSP + Factory Pattern)
interface PaymentMethod {
    fun processPayment(amount: Double): Boolean
}
class CashPayment : PaymentMethod {
    override fun processPayment(amount: Double): Boolean {
        println("\n========== PAYMENT ==========")
        println("Payment Method : Cash to Driver")
        println("Amount Payable : Rs. $amount")
        println("Status         : Payment Received by Driver")
        return true
    }
}

class CreditCardPayment : PaymentMethod {
    override fun processPayment(amount: Double): Boolean {
        println("\n========== PAYMENT ==========")
        println("Payment Method : Credit / Debit Card")
        println("Amount Paid    : Rs. $amount")
        println("Status         : Online Card Payment Successful")
        return true
    }
}

class JazzCashPayment : PaymentMethod {
    override fun processPayment(amount: Double): Boolean {
        println("\n========== PAYMENT ==========")
        println("Payment Method : JazzCash Wallet")
        println("Amount Paid    : Rs. $amount")
        println("Status         : Transaction Successful")
        return true
    }
}

class EasyPaisaPayment : PaymentMethod {
    override fun processPayment(amount: Double): Boolean {
        println("\n========== PAYMENT ==========")
        println("Payment Method : EasyPaisa Wallet")
        println("Amount Paid    : Rs. $amount")
        println("Status         : Transaction Successful")
        return true
    }
}

object PaymentFactory {
    fun create(choice: Int): PaymentMethod {
        return when (choice) {
            1 -> CashPayment()
            2 -> CreditCardPayment()
            3 -> JazzCashPayment()
            4 -> EasyPaisaPayment()
            else -> throw IllegalArgumentException("Invalid Payment Choice!")
        }
    }
}

// 6. NOTIFICATION SYSTEM MODULE (ISP + DIP)
// Small, specific interfaces (Interface Segregation).

interface NotificationService {
    fun sendNotification(recipient: String, message: String)
}

class AppPushNotification : NotificationService {
    override fun sendNotification(recipient: String, message: String) {
        println("\n========== NOTIFICATION ==========")
        println("Type    : Mobile App Push Alert")
        println("To      : $recipient")
        println("Message : $message")
    }
}

class SMSNotification : NotificationService {
    override fun sendNotification(recipient: String, message: String) {
        println("\n========== NOTIFICATION ==========")
        println("Type    : SMS Alert")
        println("To      : $recipient")
        println("Message : $message")
    }
}

class EmailReceiptNotification : NotificationService {
    override fun sendNotification(recipient: String, message: String) {
        println("\n========== NOTIFICATION ==========")
        println("Type    : Email Invoice")
        println("To      : $recipient")
        println("Message : $message")
    }
}

object NotificationFactory {
    fun create(choice: Int): NotificationService {
        return when (choice) {
            1 -> AppPushNotification()
            2 -> SMSNotification()
            3 -> EmailReceiptNotification()
            else -> throw IllegalArgumentException("Invalid Notification Choice!")
        }
    }
}
// 7. CORE SERVICE MANAGER (DIP)
// Depends completely on Abstractions (Interfaces)

class RideBookingManager(
    private val fareCalculator: FareCalculator,
    private val driverMatcher: DriverMatchingStrategy
) {
    fun processBooking(
        passenger: Passenger,
        location: Location,
        vehicle: VehicleType,
        paymentMethod: PaymentMethod,
        notificationService: NotificationService,
        availableDrivers: List<Driver>,
        promoCode: String
    ): RideReceipt? {

        //  Calculate Fare
        val baseFare = fareCalculator.calculateBaseFare(location.distanceInKm, vehicle.ratePerKm)
        val finalFare = fareCalculator.applyDiscount(baseFare, promoCode)

        //  Match Driver (LSP + Strategy)
        val assignedDriver = driverMatcher.matchDriver(availableDrivers)

        //  Process Payment (OCP)
        val paymentSuccess = paymentMethod.processPayment(finalFare)

        if (paymentSuccess) {
            val receipt = RideReceipt(
                rideId = "RIDE-" + (1000..9999).random(),
                passenger = passenger,
                location = location,
                totalFare = finalFare,
                driver = assignedDriver
            )

            // 4. Send Notification (ISP + DIP)
            notificationService.sendNotification(
                passenger.name,
                "Your ride ${receipt.rideId} is confirmed with ${assignedDriver.name} (${assignedDriver.vehicleName}). Total Fare: Rs. $finalFare"
            )

            return receipt
        }

        return null
    }
}

fun main() {
    val fareCalc = FareCalculator()
    val driverMatcher = NearestDriverStrategy()
    val bookingManager = RideBookingManager(fareCalc, driverMatcher)

    // Dummy Driver Database
    val drivers = listOf(
        Driver(101, "Ali Raza", "Toyota Corolla - LEB 452", 4.8),
        Driver(102, "Usman Khan", "Honda Civic - WX 889", 4.9),
        Driver(103, "Ahmed Noor", "Honda 70cc - KHI 123", 4.5),
        Driver(104, "Tariq Mahmood", "Auto Rickshaw - RWP 771", 4.6)
    )

    val currentPassenger = Passenger(1, "Sanila Shahzadi", "0300-1234567")

    while (true) {
        println("\n==========================================")
        println("     SMART RIDE BOOKING SYSTEM    ")
        println("==========================================")
        println("1. Book a New Ride")
        println("2. View Available Drivers")
        println("3. Exit System")
        print("Select Option: ")

        when (readln().toIntOrNull() ?: 3) {
            1 -> {
                println("\n--- STEP 1: Enter Ride Details ---")
                print("Enter Pickup Location  : ")
                val pickup = readln()

                print("Enter Dropoff Location : ")
                val dropoff = readln()

                print("Enter Distance in Km   : ")
                val distance = readln().toDoubleOrNull() ?: 10.0
                val rideLocation = Location(pickup, dropoff, distance)
                println("\n--- STEP 2: Choose Vehicle Category ---")
                println("1. Standard Car (Rs. 60/km)")
                println("2. Premium Car  (Rs. 120/km)")
                println("3. Bike Ride    (Rs. 30/km)")
                println("4. Rickshaw     (Rs. 40/km)")
                print("Choose Vehicle (1-4): ")
                val vehicleChoice = readln().toIntOrNull() ?: 1
                val vehicle = VehicleFactory.create(vehicleChoice)

                println("\n--- STEP 3: Apply Promo Code ---")
                print("Enter Promo Code (Press Enter to Skip, or use 'SAVE10'): ")
                val promoCode = readln()
                val estimatedFare = fareCalc.applyDiscount(
                    fareCalc.calculateBaseFare(distance, vehicle.ratePerKm),
                    promoCode
                )
                println(">>> Estimated Fare for Ride: Rs. $estimatedFare <<<")

                println("\n--- STEP 4: Select Payment Method ---")
                println("1. Cash")
                println("2. Credit / Debit Card")
                println("3. JazzCash")
                println("4. EasyPaisa")
                print("Choose Payment Option (1-4): ")
                val paymentChoice = readln().toIntOrNull() ?: 1
                val paymentMethod = PaymentFactory.create(paymentChoice)

                println("\n--- STEP 5: Choose Notification Preference ---")
                println("1. Mobile Push Alert")
                println("2. SMS Message")
                println("3. Email Receipt")
                print("Choose Notification Option (1-3): ")
                val notificationChoice = readln().toIntOrNull() ?: 1
                val notificationService = NotificationFactory.create(notificationChoice)

                println("\nProcessing your booking request...")

                val receipt = bookingManager.processBooking(
                    passenger = currentPassenger,
                    location = rideLocation,
                    vehicle = vehicle,
                    paymentMethod = paymentMethod,
                    notificationService = notificationService,
                    availableDrivers = drivers,
                    promoCode = promoCode
                )

                if (receipt != null) {
                    println("\n==========================================")
                    println("       RIDE BOOKING SUMMARY INVOICE       ")
                    println("==========================================")
                    println("Booking ID   : ${receipt.rideId}")
                    println("Passenger    : ${receipt.passenger.name}")
                    println("Route        : ${receipt.location.pickupPoint} ➔ ${receipt.location.dropLocation}")
                    println("Distance     : ${receipt.location.distanceInKm} km")
                    println("Vehicle      : ${vehicle.getVehicleCategory()}")
                    println("Driver       : ${receipt.driver.name} (${receipt.driver.vehicleName})")
                    println("Total Billed : Rs. ${receipt.totalFare}")
                    println("==========================================\n")
                }
            }

            2 -> {
                println("\n===== NEARBY AVAILABLE DRIVERS =====")
                drivers.forEach {
                    println("ID: ${it.id} | Name: ${it.name} | Vehicle: ${it.vehicleName} | Rating:  ${it.rating}")
                }
            }

            3 -> {
                println("\nThank you for using Smart Ride Booking System. Goodbye!")
                return
            }

            else -> println("\nInvalid Option! Please try again.")
        }
    }
}
// SOLID PRINCIPLES IMPLEMENTATION EXPLANATION

// 1. Single Responsibility Principle (SRP)
// Applied in: FareCalculator, Data Classes (Passenger, Driver, Location)
// Description: Each class handles only one specific responsibility. Data classes hold
// ride details, FareCalculator calculates distance and discounts, and RideBookingManager
// only orchestrates the booking steps.

// 2. Open/Closed Principle (OCP)
// Applied in: VehicleType, PaymentMethod, NotificationService, DriverMatchingStrategy
// Description: The system is open for extension but closed for modification. If we want
// to add a new payment method (e.g., Nayapay) or a new vehicle type (e.g., Heavy Bike),
// we simply create a new class implementing the interface without altering existing logic.

// 3. Liskov Substitution Principle (LSP)
// Applied in: Polymorphic Interfaces (VehicleType, PaymentMethod, NotificationService)
// Description: Subclasses (e.g., PremiumCar, JazzCashPayment, SMSNotification) can seamlessly
// replace their parent interfaces inside RideBookingManager without causing bugs or unexpected behavior.

// 4. Interface Segregation Principle (ISP)
// Applied in: Small, specific interfaces (NotificationService, PaymentMethod)
// Description: Interfaces are kept small and focused. Classes only implement methods
// that they actually need instead of forcing giant multi-purpose interfaces.

// 5. Dependency Inversion Principle (DIP)
// Applied in: RideBookingManager
// Description: RideBookingManager depends on abstractions (interfaces like VehicleType,
// PaymentMethod, NotificationService) rather than concrete implementations. This ensures
// loose coupling and makes the system flexible to changes.