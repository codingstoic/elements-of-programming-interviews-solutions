package ch5PrimitiveTypes

fun main(args: Array<String>) {
    println(swap(10, 0, 3))
}

fun swap(x: Int, j: Int, i: Int): Int {
    var xCopy = x
    if(x.shr(i).and(1) != x.shr(j).and(1)){
        xCopy = x.xor(1.shl(i).or(1.shl(j)))
    }

    return xCopy
}

