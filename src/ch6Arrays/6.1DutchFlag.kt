package ch6Arrays

import ch5PrimitiveTypes.swap

fun main(args: Array<String>) {
    solution1(arrayOf(3, 5, 4, 6, 7, 1, 2), 2).forEach {
        print(it)
    }

    println()

    solution2(arrayOf(3, 5, 4, 6, 7, 1, 2), 2).forEach {
        print(it)
    }

    println()

    solution3(arrayOf(3, 5, 4, 6, 7, 1, 2), 2).forEach {
        print(it)
    }

    println()

    solution4(arrayOf(3, 5, 4, 6, 7, 1, 2), 2).forEach {
        print(it)
    }
}

// running time O(n), space complexity 0(n)
fun solution1(numbers: Array<Int>, pivotPosition: Int): IntArray {
    val pivot = numbers[pivotPosition]
    val smallerElements = IntArray(numbers.size)
    var smallerIndex = 0
    val largerElements = IntArray(numbers.size)
    var largerIndex = 0
    val finalArray = IntArray(numbers.size)
    var finalIndex = 0

    numbers.forEach {
        if (it < pivot) {
            smallerElements[smallerIndex++] = it
        }
        if (it > pivot) {
            largerElements[largerIndex++] = it
        }
    }

    smallerElements.forEach {
        if (it != 0) {
            finalArray[finalIndex++] = it
        }
    }

    finalArray[finalIndex++] = pivot

    largerElements.forEach {
        if (it != 0) {
            finalArray[finalIndex++] = it
        }
    }

    return finalArray
}

// running time O(n2), space complexity 0(1)
fun solution2(numbers: Array<Int>, pivotPosition: Int): Array<Int> {
    val pivot = numbers[pivotPosition]
    // first pass move all smaller elements to beginning of the array
    for (i in 0..numbers.size) {
        for (j in i + 1 until numbers.size) {
            if (numbers[j] < pivot) {
                numbers.swap(i, j)
            }
        }
    }

    //second pass move all bigger elements to the right
    for (i in numbers.size-1 downTo 0) {
        for (j in i - 1 downTo 0) {
            if (numbers[j] > pivot) {
                numbers.swap(i, j)
            }
        }
    }

    return numbers
}

// complexity running time O(n) and space complexity O(n)
fun solution3(numbers: Array<Int>, pivotPosition: Int): Array<Int> {
    var leftIndex = 0
    var rightIndex = numbers.size - 1
    val pivot = numbers[pivotPosition]

    for(i in 0 until numbers.size){
        if(numbers[i] < pivot){
            numbers.swap(leftIndex++, i)
        }
    }

    for(i in numbers.size-1 downTo 0){
        if(numbers[i] > pivot){
            numbers.swap(rightIndex--, i)
        }
    }

    return numbers
}

/*
 The idea here is that we mark regions, smaller than pivot on the left,
 then the pivot, then unclassified elements left from the result of previous swapping
 then bigger elements
 */
fun solution4(numbers: Array<Int>, pivotPosition: Int): Array<Int> {
    var smaller = 0
    var equal = 0
    val pivot = numbers[pivotPosition]
    var bigger = numbers.size - 1

    // while we have unclassified elements until all are classified iterate
    while(equal < bigger){
        when {
            numbers[equal] < pivot -> numbers.swap(equal++, smaller++)
            numbers[equal] > pivot -> numbers.swap(bigger--, equal)
            numbers[equal] == pivot -> equal++
        }
    }

    return numbers
}

fun Array<Int>.swap(a: Int, b: Int){
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}
