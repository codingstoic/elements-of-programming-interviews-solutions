package ch5PrimitiveTypes

fun main(args: Array<String>) {
    val input = -987654321
    println(input)
    println(reverseIt(input))
}

fun reverseIt(num: Int): Int {
    val isNegative = num < 0
    var original = Math.abs(num)
    var result = 0

     while (original > 0){
        result = result * 10 + original.rem(10)
        original /= 10

    }

    return if(isNegative) -result else result
}

// takes more memory
fun bruteForce(num: Int): String {
    val inString = num.toString()
    return inString.reversed()
}

