package ch6Arrays

fun main(args: Array<String>) {
    //[3,2,1,0,0,0,1] -> false
    //[3,3,2,0,2,1] -> true
    println(canReachTheEnd(arrayOf(3, 2, 1, 0, 0, 0, 1)))
    println(canReachTheEnd(arrayOf(3, 3, 2, 0, 2, 1)))
}

fun canReachTheEnd(array: Array<Int>): Boolean {
    var maximumIndex = 0
    array.forEachIndexed { index, number ->
        if (index <= maximumIndex) {
            maximumIndex = Math.max(maximumIndex, index + number)
        }
        // optimisation, if we know we can reach the at some point no need
        // to continue the loop
        if (maximumIndex >= array.size - 1) {
            return true
        }
    }

    return maximumIndex >= array.size - 1
}

