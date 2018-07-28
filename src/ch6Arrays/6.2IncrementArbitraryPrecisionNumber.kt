package ch6Arrays

fun main(args: Array<String>) {
    println(addOne(mutableListOf(1,2,9)))
}

fun addOne(list: MutableList<Int>): MutableList<Int> {
    for(i in (list.size-1).downTo(0)){
        if((list[i] + 1) == 10) {
            list[i] = 0
        } else {
            list[i] += 1
            break
        }
    }

    if(list[0] == 10){
        list[0] = 0
        list.add(0, list[0] + 1)
    }

    return list
}

