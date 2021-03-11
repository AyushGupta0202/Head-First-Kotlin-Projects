//Giving an alias name to (Double) -> Double
typealias DoubleConversion = (Double) -> Double

//Function returning a lambda
fun getConversionLambda(str: String) : DoubleConversion {
    when (str) {
        "CentigradeToFahrenheit" -> return {it * 1.8 + 32}
        "KgsToPounds" -> return {it * 2.204623}
        "PoundsToUSTons" -> return {it / 2000}
        else -> return {it}
    }
}

fun main() {
    val addFive = {x: Int -> x + 5}
    println("Pass 6 to addFive: ${addFive(6)}")

    val addInts = { x: Int, y: Int -> x + y }
    val result = addInts.invoke(6, 7)
    println("Pass 6, 7 to addInts: $result")

    val intLambda: (Int, Int) -> Int = { x, y -> x * y}
    println("Pass 10, 11 to intLambda: ${intLambda(10, 11)}")

    val addSeven: (Int) -> Int = {it + 7}
    println("Pass 12 to addSeven: ${addSeven(12)}")

    val myLambda: () -> Unit = { println("Hi!") }
    myLambda()

    convert(20.0) {it * 1.8 + 32}
    convertFive { it * 1.8 + 32 }

    //Convert 2.5 kgs to pounds
    println("Convert 2.5 kg to pounds : ${getConversionLambda("KgsToPounds") (2.5)}")

    //Define two conversion lambdas
    val kgsToPoundsLambda = getConversionLambda("KgsToPounds")
    val poundsToUSTonsLambda = getConversionLambda("PoundsToUSTons")

    //Combine two lambdas to create a new one
    val kgsToUSTonsLambda = combine(kgsToPoundsLambda, poundsToUSTonsLambda)

    //Use the new lambda to convert 17.4 to US Tons
    val value = 17.4
    println("$value kgs is: ${convert(value, kgsToUSTonsLambda)} US Tons")
}

//Function that takes two lambda parameters and returns a lambda
fun combine(lambda1: DoubleConversion,
            lambda2: DoubleConversion) : DoubleConversion {
    return {x : Double -> lambda2(lambda1(x))}
}

fun convert(x: Double, converter: DoubleConversion) : Double {
    val result = converter(x)
    println("$x is converted to $result")
    return result
}

fun convertFive(converter: (Int) -> Double) : Double {
    val result = converter(5)
    println("5 is converted to $result")
    return result
}
