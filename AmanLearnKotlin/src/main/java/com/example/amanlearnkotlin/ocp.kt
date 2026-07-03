package com.example.amanlearnkotlin.com.example.amanlearnkotlin
import java.lang.IllegalArgumentException

// VIOLATION EXAMPLE: Why modifying existing files breaks OCP
// Imagine we have a basic reporting app that handles different export formats.
// Look at how adding a new format forces us to modify the existing process function.

enum class ExportType {
    PDF, CSV, JSON // If we want to add XML later, we have to touch this enum too!
}

class BadReportExporter {
    fun export(data: String, type: ExportType) {
        if (type == ExportType.PDF) {
            println("Converting data to PDF file structure...")
        } else if (type == ExportType.CSV) {
            println("Converting data to comma-separated values...")
        } else if (type == ExportType.JSON) {
            // We had to come back into this class and modify it to add JSON!
            // This is a direct violation of the Open/Closed Principle.
            println("Formatting data into a JSON object string...")
        }
    }
}


// CLEAN SOLUTION: Adhering to the Open/Closed Principle (OCP)
// We achieve this by using an interface. The core processor is now CLOSED for
// modification because it never needs to change when a new format is added.
// It is completely OPEN for extension because any developer can implement the interface.

interface ReportFormatter {
    fun format(data: String)
}

// Extension 1: PDF Handling
class PdfFormatter : ReportFormatter {
    override fun format(data: String) {
        println("Exporting: Creating a beautiful, structured PDF layout.")
    }
}

// Extension 2: CSV Handling
class CsvFormatter : ReportFormatter {
    override fun format(data: String) {
        println("Exporting: Building standard comma-separated spreadsheet values.")
    }
}

// Extension 3: JSON Handling (Added smoothly without changing any previous code!)
class JsonFormatter : ReportFormatter {
    override fun format(data: String) {
        println("Exporting: Parsing plain attributes into clean raw JSON format.")
    }
}

// The Core Engine/Manager class.
// Notice how this class is totally independent. It accepts the abstraction.
// If tomorrow marketing demands XML or Excel exports, this class remains entirely untouched!
class ReportExporter(private val formatter: ReportFormatter) {
    fun executeExport(reportData: String) {
        // Polymorphism safely handles which concrete version runs at runtime
        formatter.format(reportData)
    }
}

// Running our cleaner, decoupled application architecture
fun main() {
    val samplePayload = "User_ID_102, Active, Premium_Account"

    // To export to PDF, we just plug in the PDF formatter component
    val pdfExportEngine = ReportExporter(PdfFormatter())
    pdfExportEngine.executeExport(samplePayload)

    // To export to JSON, we plug in the JSON component without editing any core business files
    val jsonExportEngine = ReportExporter(JsonFormatter())
    jsonExportEngine.executeExport(samplePayload)
}