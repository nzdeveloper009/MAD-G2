import kotlin.math.PI
fun checkage(age:Int?):String {
    age?.let {
        if (age >= 18) {
            return "adult"
        }
        else (age<18)
        return "minor"


    }
    return "age not provided"
}


fun String.countvowels():Int {
    var count=0;
    for(ch in this.lowercase()){
        if(ch in "aeiou"){
            count++;
        }
    }
    return count;
}

fun main(){
    val age=18;
    println(checkage(age));


    //task 2
    var text="hello ILMAS";
        println(text.countvowels());


    // task 3
    val products:List <product> =listOf(
        product("glass",200.0),
        product("mirror",300.0)
    );
     val expensiveProducts= products.filter{
         it.price>100;
     }
     // print
    expensiveProducts.forEach { println(it.name) }

    // task 4
    val shape:Shape=Shape.Circle(2.0);
    val area=when(shape) {
        is Shape.Circle -> shape.radius * shape.radius * PI;
        is Shape.Rectangle -> shape.height * shape.width;

    }
    println(area);
}
sealed class Shape{
    class Circle(val radius:Double):Shape();
    class Rectangle(val width:Double,val height:Double):Shape();

}
data class  product(val name:String,val price:Double);

