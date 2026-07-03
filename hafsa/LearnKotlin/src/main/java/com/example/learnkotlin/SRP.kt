package com.example.learnkotlin
// A class with multiple functions
//class Grade {
//
//    fun addStudent(name: String) {
//        println("$name added successfully")
//    }
//
//    fun calculateGrade(marks: Int) {
//        if (marks >= 50)
//            println("Pass")
//        else
//            println("Fail")
//    }
//
//    fun saveToDatabase(name: String) {
//        println("$name saved to database")
//    }
//}

// multiple classes for multiple reasons and reponsibilities
class Grades(var name: String, var marks: Int) {

    fun displayStudent() {
        println("Student Name: $name")
        println("Marks: $marks")
    }
}

class GradeCalculator {

    fun calculateGrade(marks: Int) {
        if (marks >= 50)
            println("Result: Pass")
        else
            println("Result: Fail")
    }
}

class database {

    fun saveStudent(name: String) {
        println("$name saved to database")
    }
}


fun main() {

    val student = Grades ("Ali", 78)
    student.displayStudent()

    val calgrade = GradeCalculator()
    calgrade.calculateGrade(student.marks)

    val database = database()
    database.saveStudent(student.name)

}
