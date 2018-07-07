package ch5PrimitiveTypes

import java.util.*

fun main(args: Array<String>) {
    repeat(10, {
        println(randomNumberInclusive(5, 15))
    })
}

fun randomNumberInclusive(a: Int, b: Int): Int {
    val diff = b - a
    var result = 0

    do {
        var currentNumber = 0

        while(1.shl(currentNumber) <= diff){
            currentNumber += 1
            result = if(result == 0) randomBit() else result.shl(1)
        }

    } while (result > diff)

    return a + result
}


val random = Random()

fun randomBit(): Int{
    return random.nextInt(2)
}