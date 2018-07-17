package ch5PrimitiveTypes

fun main(args: Array<String>) {
    println(closestWeight(6))
}

fun closestWeight(x: Int): Int{
    var closestValue = x
    for(i in 0..63){
        if(x.shr(i).and(1) != x.shr(i+1).and(1)){
            closestValue = x.xor(1.shl(i).or(1.shl(i+1)))
            break
        }
    }

    return closestValue
}

