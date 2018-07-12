package ch5PrimitiveTypes

fun main(args: Array<String>) {
    println(divide(12, 2))
}

fun divide(x: Int, y: Int): Long {
    var xCopy = x
    val yCopy = y
    var result = 0L
    var power = 32
    var yPower = y.shl(power)

    while(xCopy >= yCopy){
        while(yPower > x){
            yPower = yPower.shr(1)
            power -= 1
        }
        xCopy -= yPower
        result += 1.shl(power)
    }

    return result
}

