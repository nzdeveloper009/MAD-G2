package com.example.lib
import kotlin.properties.Delegates
//using trational mathod
interface subscriber{
    fun update(title: String)
}

class youtubeUser(val name: String): subscriber{
    override fun update(title: String) {
        println("$name got notification $title")
    }

}
class youtubeChannel{
    private val subscribers=mutableListOf<subscriber>()
    fun addSub(s: subscriber){
        subscribers.add(s)

    }
    fun uploadVideo(tile: String){
        for(s in subscribers){
            s.update(tile)
        }
    }
}
// Delegates variable
class PhoneUser(val name: String) {
    fun update(temp: Int) { println("$name got temp: ${temp}°C") }
}
/*fun main() {
    val userList = mutableListOf(PhoneUser(" sanila"), PhoneUser("Amna"))
    var temperature: Int by Delegates.observable(20) { _, old, new ->
        println("Changed: ${old}°C → ${new}°C")
        for (user in userList) { user.update(new) }
    }
    temperature = 35
}*/
// Using lambda function
/*fun main() {
    val observers = mutableListOf<(Int) -> Unit>()
    observers.add { temp -> println("Samsung Display: ${temp}°C") }
    observers.add { temp -> println("Lenovo Desktop: ${temp}°C") }
    observers.add { temp -> println("Orient TV: ${temp}°C") }
    fun tempUpdate(newTemp: Int) {
        for (observer in observers) {
            observer(newTemp)
        }
    }
    tempUpdate(35)
}*/
// using API flow
fun main(){
    val fakeApiJson = """{"city": "Lahore", "temperature": 38}"""


val apiTemp = fakeApiJson
    .substringAfter("\"temperature\":")
    .substringBefore("}")
    .trim()
    .toInt()
println("API returned: ${apiTemp}°C")
temperature = apiTemp              // Delegates → auto-fires
tempUpdate(apiTemp)                // Lambda → notifies all
 youtubeChannel.uploadVideo("${apiTemp}°C") // Traditional → loops list
}