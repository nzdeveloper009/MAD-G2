package com.example.amanlearnkotlin.com.example.amanlearnkotlin

import java.io.File

// CONCEPT: Single Responsibility Principle (SRP)
// This class only cares about the order data and calculating the tax.
// It has no clue if it's being displayed on a screen or saved to a database.
// One job, one reason to change (if tax laws change!).
class Invoice(
    val orderId: String,
    val itemsAmount: Double
) {
    // Just simple math logic here
    fun calculateTotal(): Double {
        val taxRate = 0.18 // 18% tax
        return itemsAmount + (itemsAmount * taxRate)
    }
}

// CONCEPT: Separation of Concerns (UI/Presentation Layer)
// This class handles the layout and formatting.
// If design wants to change how the receipt looks, we only touch this code.
class InvoicePrinter {

    fun printReceipt(invoice: Invoice) {
        val totalAmount = invoice.calculateTotal()

        // Making the output look clean on the console
        println("            OFFICIAL RECEIPT             ")
        println("Invoice ID : #${invoice.orderId}")
        println("Subtotal   : $${invoice.itemsAmount}")
        println("Grand Total: $totalAmount")
    }
}

// CONCEPT: Data Persistence Layer (Repository Pattern)
// This handles the storage plumbing. Right now it just dumps it into a text file.
// If we switch to Room DB or Firebase next week, only this class gets rewritten.
// The rest of the app won't care at all.
class InvoiceRepository {

    fun saveToFile(invoice: Invoice) {
        try {
            val targetFile = File("invoice_${invoice.orderId}.txt")

            // Just saving a basic string report to the disk
            targetFile.writeText("ID: ${invoice.orderId} | Paid Total: $${invoice.calculateTotal()}")
            println("Dev Log: File saved without any issues.")

        } catch (error: Exception) {
            // Catching errors here so a file failure doesn't crash the whole app
            println("Uh oh, something went wrong saving the file: ${error.localizedMessage}")
        }
    }
}

// CONCEPT: Loose Coupling & Coordination
// Think of this as the supervisor. It creates the small tools and tells them
// what to do, keeping them completely independent of each other.
fun main() {
    // Spin up our utility classes
    val systemPrinter = InvoicePrinter()
    val dataRepository = InvoiceRepository()

    // Create a mock order to test the system
    val currentInvoice = Invoice(orderId = "ORD-2026", itemsAmount = 150.0)

    // Hand off the invoice to the classes that actually know what to do with it
    systemPrinter.printReceipt(currentInvoice)
    dataRepository.saveToFile(currentInvoice)
}