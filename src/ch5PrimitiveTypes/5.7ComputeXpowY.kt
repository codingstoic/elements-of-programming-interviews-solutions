package ch5PrimitiveTypes

import kotlin.math.abs

fun main(args: Array<String>) {
    println(power(2.0, 6))
}

fun power(x: Double, y: Int): Double{
    var xCopy = if(y < 0) 1.0.div(x) else x
    var yCopy = abs(y)
    var result = 1.0

    while(yCopy != 0){
        if(yCopy.and(1) == 1){
            result *= xCopy
        }
        xCopy *= xCopy
        yCopy = yCopy.shr(1)
    }

    return result
}

