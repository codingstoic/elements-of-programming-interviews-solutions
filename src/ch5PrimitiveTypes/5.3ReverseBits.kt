package ch5PrimitiveTypes

private val cache = arrayOf(-1,-1,-1, -1)

fun main(args: Array<String>) {
    println(reverseBits(240))
}

// hardcoded for 8 bits, but principles apply to an arbitrary word size
fun reverseBits(x: Int): Int {
    val bitMask = 1.shl(1).or(1)
    var reversed = 0

    for(i in 0..6 step 2){
        val currentTwoBits = x.shr(i).and(bitMask)
        val currentTowBitsReversed = reverseTwoBits(currentTwoBits)

        reversed = if(i == 0){
            currentTowBitsReversed
        } else {
            reversed.shl(2).or(currentTowBitsReversed)
        }
    }

    return reversed
}

fun reverseTwoBits(x: Int): Int {
    if(cache[x] == -1){
        val lastBit = x.and(1)
        val firstBit = x.shr(1).and(1)
        cache[x] = lastBit.shl(1).or(firstBit)
    }
    return cache[x]
}

