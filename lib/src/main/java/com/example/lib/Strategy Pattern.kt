package com.example.lib
interface validator{
    fun isValid(value: String): Boolean
}
class EmailValidator: validator{
    override fun isValid(value: String)=value.contains("@")

}
class PhoneValidator: validator{
    override fun isValid(value: String)=value.length==10

}
class FormField(val name: String, val validator: validator){
    fun validate(value: String)=validator.isValid(value)
}
/*fun main() {
    val emailField = FormField("Email", EmailValidator())
    val phoneField = FormField("Phone", PhoneValidator())
    println(emailField.validate("abc@gmail.com"))  // true
    println(phoneField.validate("0333848617"))     // true
}*/
 // Using 2nd method-> Lambda
typealias  ValidationStrategy=(String)-> Boolean
 class Formfield(val name: String, val validation: ValidationStrategy)

fun main() {
    val emailField = FormField("Email") { it.contains("@") }
    val passwordField = FormField("Password") { it.length >= 8 }
    println(emailField.validation("abc123@gmail.com"))  // true
    println(passwordField.validation("123478"))          // false
}