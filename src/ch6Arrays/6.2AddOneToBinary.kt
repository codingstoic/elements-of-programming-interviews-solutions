package ch6Arrays

fun main(args: Array<String>) {
    println(addOne(mutableListOf(1,0,1,1,1)))
}

fun addOne(list: MutableList<Int>): MutableList<Int> {
    var carryOver = 1

    for(i in (list.size-1).downTo(0)){
        if(list[i] == 0 && carryOver == 1) {
            carryOver = 0
            list[i] = 1
        } else if(list[i] == 1 && carryOver == 1) {
            carryOver = 1
            list[i] = 0
        }
    }

    if(carryOver == 1){
        list.add(0, 1)
    }

    return list
}

