package ch6Arrays

enum class Categories {
    CATEGORY_1, CATEGORY_2, CATEGORY_3, NO_CATEGORY
}

fun main(args: Array<String>) {
    variant1(arrayOf(
            Categories.CATEGORY_3,
            Categories.CATEGORY_2,
            Categories.CATEGORY_1,
            Categories.CATEGORY_2,
            Categories.CATEGORY_1,
            Categories.CATEGORY_3)
    ).forEach {
        print(it)
        print(" ")
    }
}

// sort an array such that elements wit the same category appear together
fun variant1(items: Array<Categories>): Array<Categories> {
    var groupOneRMI = 0
    var groupTwoRMI = 0
    var groupThreeLMI = items.size - 1

    while (groupTwoRMI < groupThreeLMI) {

        when {
            items[groupTwoRMI] == Categories.CATEGORY_1 -> items.swap(groupOneRMI++, groupTwoRMI++)
            items[groupTwoRMI] == Categories.CATEGORY_2 -> items.swap(groupTwoRMI, groupThreeLMI--)
            items[groupTwoRMI] == Categories.CATEGORY_3 -> groupTwoRMI++
        }
    }

    return items
}

fun Array<Categories>.swap(a: Int, b: Int) {
    val tmp = this[a]
    this[a] = this[b]
    this[b] = tmp
}
