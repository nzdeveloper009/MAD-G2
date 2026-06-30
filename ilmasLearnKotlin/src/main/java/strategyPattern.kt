//strategy pattern is the behavioral pattern
//behavioral pattren
//----- it is the communication between multiple objects to perform multiple tasks

//----> what is strategy pattern
////    strategy Pattern lets us create multiple algorithms separately and switch
// between them whenever we want.

// example
//   google maps-------when we select(car,bike,walking) only the rotes changes not the google map
///   routes changed according to our choice not the working of the google map changed


// it is runtime switching
//      Runtime means:
//     While the application is running.
//      Suppose user selects
//       "PayPal"
//       Application uses PayPal strategy.
//       Next second user selects
//         "Credit Card"
//         Application switches immediately.
//          No code modification.
//          No restart.
//         This is runtime switching.




//        without strategy pattern
fun pay(amount: Double, type: String) {

    if(type=="CARD"){

    }

    else if(type=="PAYPAL"){

    }

    else if(type=="CRYPTO"){

    }

}
//    ------- problems: -----------
   // Looks fine initially.
//    But imagine after one year.
//
//Your company adds:
//  Apple Pay
//  Google Pay
//  Stripe
//  Bank Transfer
//  Cash
//  Now your function becomes
//if
//else if
//else if
//else if
//else if
//else if
//else if

//   Problem 1 — Hard to Maintain
//   Problem 2 — Violates Open/Closed Principle
//   Problem 3 — Messy Code
                           // strategy pattern core components
                          //         Context
//                                      |
//                                      |
//                               Strategy Interface
//                                 /      |      \
//                                /       |       \
//                              Email    Phone   Password
//                             Validator Validator Validator

//   ---- classical strategy pattern

// Strategy Interface
interface Validator {
    fun isValid(value: String): Boolean
}

// Concrete Strategy 1
class EmailValidator : Validator {
    override fun isValid(value: String): Boolean {
        return value.contains("@")
    }
}

// Concrete Strategy 2
class PhoneValidator : Validator {
    override fun isValid(value: String): Boolean {
        return value.length == 10
    }
}

// Context Class
class FormField(
    val name: String,
    val validator: Validator
) {

    fun validate(value: String): Boolean {
        return validator.isValid(value)
    }
}
//   --- run time switching
interface Validators {
    fun isValid(value: String): Boolean
}

class EmailValidators : Validators {
    override fun isValid(value: String): Boolean {
        return value.contains("@")
    }
}

class PhoneValidators : Validators {
    override fun isValid(value: String): Boolean {
        return value.length == 10
    }
}



//------ modern kotlin way lambda strategy
typealias ValidationStrategy = (String) -> Boolean

class FormFields(
    val name: String,
    val validation: ValidationStrategy
)

//------  runtime switching strategy----------
typealias ValidationStrategy2 = (String) -> Boolean



// Main Function
fun main() {

    val emailField = FormField(
        "Email",
        EmailValidator()
    )

    val phoneField = FormField(
        "Phone",
        PhoneValidator()
    )

    println("Email Validation:")
    println(emailField.validate("abc@gmail.com"))

    println()

    println("Phone Validation:")
    println(phoneField.validate("0333848617"))

    println("--------------------------------------------")
    println("runtime switching")

    var validator: Validators = EmailValidators()

    println(validator.isValid("abc@gmail.com"))
    // true

    // Runtime Strategy Switch
    validator = PhoneValidators()

    println(validator.isValid("0333848617"))
    // true


    println("---------------------------------------")
    println("modern kotlin way lambda strategy")
    val emailFields = FormFields("Email", {
        it.contains("@")
    })

    val passwordField = FormFields("Password") {
        it.length >= 8
    }

    println(emailFields.validation("abc@gmail.com"))
    println(passwordField.validation("12345678"))
    println("---------------------------------------")
    println("modern kotlin way runtime switching with lambda strategy")

    var strategy: ValidationStrategy2 = {
        it.contains("@")
    }

    println(strategy("abc@gmail.com"))

    // Switch Strategy
    strategy = {
        it.length >= 8
    }

    println(strategy("1234567"))
}


