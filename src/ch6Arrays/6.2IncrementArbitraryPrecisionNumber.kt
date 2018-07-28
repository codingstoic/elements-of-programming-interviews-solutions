package ch6Arrays

fun main(args: Array<String>) {
    println(addOne(mutableListOf(1, 2, 9)))

    // 111
    //  11
    //1010

    println(variantSumTwoBinary("111", "11", ::sumTwoBinaryStringsBitwise))
}

fun addOne(list: MutableList<Int>): MutableList<Int> {
    for (i in (list.size - 1).downTo(0)) {
        if ((list[i] + 1) == 10) {
            list[i] = 0
        } else {
            list[i] += 1
            break
        }
    }

    if (list[0] == 10) {
        list[0] = 0
        list.add(0, list[0] + 1)
    }

    return list
}

fun variantSumTwoBinary(b1: String, b2: String, calc: (a: String, b: String) -> String): String {
    return when {
        b1.length > b2.length -> {
            var b2Copy = b2
            for (i in 0.until(b1.length - b2.length)) {
                b2Copy = "0$b2Copy"
            }
            calc(b1, b2Copy)
        }
        b2.length > b1.length -> {
            var b1Copy = b1
            for (i in 0.until(b2.length - b1.length)) {
                b1Copy = "0$b1Copy"
            }
            calc(b2, b1Copy)
        }
        else -> calc(b2, b1)
    }
}

// hard coded version
fun sumTwoBinaryStrings(b1: String, b2: String): String {
    var result = ""
    var carryOver = 0
    for (i in (b1.length - 1).downTo(0)) {
        if (b1[i] == '1' && b2[i] == '1' && carryOver == 1) {
            result = '1' + result
            carryOver = 1
        } else if (b1[i] == '1' && b2[i] == '1' && carryOver == 0) {
            result = '0' + result
            carryOver = 1
        } else if (((b1[i] == '1' && b2[i] == '0') || (b1[i] == '0' && b2[i] == '1')) && carryOver == 1) {
            result = '0' + result
            carryOver = 1
        } else if (((b1[i] == '1' && b2[i] == '0') || (b1[i] == '0' && b2[i] == '1')) && carryOver == 0) {
            result = '1' + result
        } else {
            result = '0' + result
        }
    }

    if (carryOver == 1) {
        result = '1' + result
    }

    return result
}

// simpler version
fun sumTwoBinaryStringsBitwise(b1: String, b2: String): String {
    var result = ""
    var carryIn = 0
    var carryOut: Int
    for (i in (b1.length - 1).downTo(0)) {
        val b1Int: Int = b1[i].toInt() - 48
        val b2Int: Int = b2[i].toInt() - 48
        carryOut = b1Int.and(b2Int).or(carryIn.and(b1Int)).or(carryIn.and(b2Int))
        result = b1Int.xor(b2Int).xor(carryIn).toString() + result
        carryIn = carryOut
    }

    if (carryIn == 1) {
        result = "1$result"
    }

    return result
}

/*
carry out     current Bit
a   b  cI R   a b c r
1   1  1  1   1 1 1 1
1   1  0  1   1 0 0 1
1   0  1  1   0 1 0 1
0   1  1  1   0 0 1 1
0   1  0  0

 */
