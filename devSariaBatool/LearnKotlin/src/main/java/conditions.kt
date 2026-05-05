//if else
fun main() {
    val isRaining = true
    if (isRaining==true){
        println("Take Umbrella")
    }
    else{
        println("No rains - Enjoy yoyr day")
    }
    Secondmain()
    statement()
}
fun Secondmain() {
    val x= 10
    val y= 11
    if(x>y) {
        println("X is greater then y")
    }
    else if(x<y){
        println("X is less than y")
    }
    else{
        println("X is equal to y")
    }
}
fun statement(){
    val number = 20
    val result = if(number % 2==0){
        "Even"
    }
    else{
        "Odd"
    }
    print(result)
}