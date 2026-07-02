package com.example.lib
//
/* Instead of creating many subclasses
 Decorator Pattern combines behavior dynamically using wrapping
 */
/*
                Logger
              log(String)
                  ↑
      ┌───────────────────┐
      ↑                    ↑
ConsoleLogger          Decorator
   (Base)            (holds Logger)
                          ↑
                ┌──────────────────┐
                ↑                  ↑
        TimeStampLogger      ThreadLogger
        (wraps Logger)       (wraps Logger)

 */
// Using Classic OOP Decorator
interface Logger{
    fun log(message: String)
}
class ConsloeLogger: Logger {
    override fun log(message: String) {
        println(message)
    }
}
abstract class LoggerDecorator(protected val wrappe: Logger): Logger{
    override fun log(message: String) {
       wrappe.log(message)
    }
}
class TimeStampLogger(wrappe: Logger): LoggerDecorator(wrappe){
    override fun log(message: String) {
        val time= Thread.currentThread().name
        wrappe.log("[$time] $message")
    }
}
class ThreadNameLogger(wrappee: Logger) : LoggerDecorator(wrappee) {
    override fun log(message: String) {
        val threadName = Thread.currentThread().name
        wrappe.log("[$threadName] $message")
    }
}

fun classicalDemo() {
    val baseLogger: Logger = ConsloeLogger()
    val timedLogger: Logger = TimeStampLogger(baseLogger)
    val finalLogger: Logger = ThreadNameLogger(timedLogger)

    finalLogger.log("App Started Classical Way")
}
// Using mathod->lambda
fun interface FunLogger {
    fun log(message: String)
}
// Step 2: Extension functions as Decorators
fun FunLogger.withTimeStamp(): FunLogger = FunLogger { msg ->
    this.log("[${java.time.LocalTime.now()}] $msg")
}
fun FunLogger.withThreadName(): FunLogger = FunLogger { msg ->
    this.log("${Thread.currentThread().name}: $msg")
}
fun functionalDemo() {
    val logger = FunLogger { println(it) }
        .withTimeStamp()
        .withThreadName()

    logger.log("App Started (Functional Way)")
}