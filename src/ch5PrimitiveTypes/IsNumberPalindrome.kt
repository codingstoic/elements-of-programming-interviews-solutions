package ch5PrimitiveTypes

import kotlin.math.log10

fun main(args: Array<String>) {
    val testNumber1 = 121
    val testNumber2 = 122
    val testNumber3 = 2222

    println(isPalindrome(testNumber1))
    println(isPalindrome(testNumber2))
    println(isPalindrome(testNumber3))
}

// time complexity (log10(n)/2), space complexity 0(1)
fun isPalindrome(num: Int): Boolean{
    var number = num
    val numberOfDigits = log10(number.toDouble()).toInt() + 1
    var mask = Math.pow(10.toDouble(), (numberOfDigits - 1).toDouble())

    repeat(numberOfDigits/2, {
        val mostLeft = (number / mask).toInt()
        val mostRight = number.rem(10)

        if(mostLeft != mostRight){
            return false
        }

        number = number.rem(mask).toInt()
        number /= 10
        mask /= 100
    })

    return true
}

