package com.example.amanlearnkotlin.com.example.amanlearnkotlin

import java.lang.UnsupportedOperationException

// VIOLATION EXAMPLE: Breaking ISP with a fat interface
// Imagine we are building a multi-functional office printer/scanner/fax setup.

interface BadSmartDevice {
    fun printDocument(content: String)
    fun scanDocument(): String
    fun faxDocument(content: String)
}

// Super expensive printer can do everything, so it works fine here.
class HighEndOfficePrinter : BadSmartDevice {
    override fun printDocument(content: String) = println("Printing: $content")
    override fun scanDocument(): String = "Scanned Page Data"
    override fun faxDocument(content: String) = println("Sending Fax: $content")
}

// Here is the violation. A basic home printer can only print.
// Because of the fat interface, it is forced to implement scan and fax methods it doesn't have.
// Leaving them blank or throwing crashes is a direct violation of ISP.
class BasicHomePrinter : BadSmartDevice {
    override fun printDocument(content: String) = println("Home Printer printing: $content")

    override fun scanDocument(): String {
        throw UnsupportedOperationException("Hardware Error: This printer cannot scan!")
    }

    override fun faxDocument(content: String) {
        throw UnsupportedOperationException("Hardware Error: No fax module installed!")
    }
}


// CLEAN SOLUTION: Adhering to the Interface Segregation Principle (ISP)
// To fix this, we break the fat interface down into separate, single-purpose contracts.

interface Printer {
    fun printDocument(content: String)
}

interface Scanner {
    fun scanDocument(): String
}

interface FaxMachine {
    fun faxDocument(content: String)
}

// The cheap home printer now only implements the Printer contract.
// No useless code, no empty methods, no surprise runtime crashes.
class GoodHomePrinter : Printer {
    override fun printDocument(content: String) {
        println("Printing cleanly on standard home printer setup: $content")
    }
}

// The advanced office machine can easily implement multiple interfaces at the same time.
// Kotlin allows comma-separated multi-interface implementation seamlessly.
class GoodOfficePrinter : Printer, Scanner, FaxMachine {
    override fun printDocument(content: String) = println("Heavy-duty Printing: $content")
    override fun scanDocument(): String = "High-definition Scanned Image"
    override fun faxDocument(content: String) = println("Secure Fax Transmitted: $content")
}


// Testing our segregated system
fun main() {
    // This workstation only needs printing capability
    val simplePrinter: Printer = GoodHomePrinter()
    simplePrinter.printDocument("My Android Project Report")

    // This advanced workstation can leverage all tasks independently without side-effects
    val corporateMachine = GoodOfficePrinter()
    corporateMachine.printDocument("Confidential Payroll")
    val scannedDoc = corporateMachine.scanDocument()
    println("Result: $scannedDoc")
}