package ch5PrimitiveTypes

private val cache = arrayOf(-1,-1,-1,-1)

fun main(args: Array<String>) {
    println(parity(234))
}

// designed for 8 bit words only but can be easily expanded to any other size
fun parity(word: Int): Int {
    var result = 0
    val bitMask = 1.shl(1).or(1)

    for(i in 0..6 step 2){
        val nextTwoBits = word.shr(i).and(bitMask)
        calculateParityAndStoreInCache(nextTwoBits)
        result = result.xor(nextTwoBits)
    }

    return result
}

fun calculateParityAndStoreInCache(twoBits: Int) {
    if(cache[twoBits] == -1) {
        cache[twoBits] = twoBitParity(twoBits)
    }
}

fun twoBitParity(twoBits: Int): Int {
    var parity = 0
    parity = parity.xor(twoBits.and(1))
    parity = parity.xor(twoBits.shr(1).and(1))
    return parity
}


