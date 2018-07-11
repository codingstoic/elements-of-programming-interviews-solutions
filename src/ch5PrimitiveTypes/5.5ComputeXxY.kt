package ch5PrimitiveTypes

fun main(args: Array<String>) {
    println(multiply(8,8))
}

fun multiply(x: Int, y: Int): Int{
    var sum = 0
    var xCopy = x
    var yCopy = y

    while(xCopy != 0){
        if(xCopy.and(1) == 1){
            sum = add(sum, yCopy)
        }

        xCopy = xCopy.shr(1)
        yCopy = yCopy.shl(1)
    }

    return sum
}

fun add(a: Int, b: Int): Int{
    var k = 1
    var sum = 0
    var carryIn = 0
    var aCopy = a
    var bCopy = b

    while(aCopy != 0 || bCopy !=0){
        val ak = a.and(k)
        val bk = b.and(k)
        val carryOut = ak.and(bk).or(carryIn.and(ak)).or(carryIn.and(bk))

        carryIn = carryOut.shl(1)
        sum = carryIn.xor(ak).xor(bk)

        k = k.shl(1)
        aCopy = aCopy.shr(1)
        bCopy = bCopy.shr(1)
    }

    return sum.or(carryIn)
}