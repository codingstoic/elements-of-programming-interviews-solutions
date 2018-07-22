package ch6Arrays

enum class ThreeCategories {
    CATEGORY_1, CATEGORY_2, CATEGORY_3
}

enum class FourCategories {
    CATEGORY_1, CATEGORY_2, CATEGORY_3, CATEGORY_4
}

enum class TwoCategories {
    TRUE, FALSE
}

fun main(args: Array<String>) {
    variant1(arrayOf(
            ThreeCategories.CATEGORY_3,
            ThreeCategories.CATEGORY_2,
            ThreeCategories.CATEGORY_1,
            ThreeCategories.CATEGORY_2,
            ThreeCategories.CATEGORY_1,
            ThreeCategories.CATEGORY_3)
    ).forEach {
        print(it)
        print(" ")
    }

    println()

    variant2(arrayOf(
            FourCategories.CATEGORY_1,
            FourCategories.CATEGORY_2,
            FourCategories.CATEGORY_3,
            FourCategories.CATEGORY_4,
            FourCategories.CATEGORY_4,
            FourCategories.CATEGORY_3,
            FourCategories.CATEGORY_2,
            FourCategories.CATEGORY_1
    )).forEach {
        print(it)
        print(" ")
    }

    println()

    variant3(arrayOf(
            TwoCategories.FALSE,
            TwoCategories.TRUE,
            TwoCategories.TRUE,
            TwoCategories.TRUE,
            TwoCategories.FALSE)).forEach {
        print(it)
        print(" ")
    }
}

// sort an array such that elements wit the same category appear together
// items can be in one of three categories
fun variant1(items: Array<ThreeCategories>): Array<ThreeCategories> {
    var groupOneRMI = 0
    var groupTwoRMI = 0
    var groupThreeLMI = items.size - 1

    while (groupTwoRMI < groupThreeLMI) {

        when {
            items[groupTwoRMI] == ThreeCategories.CATEGORY_1 -> items.swap(groupOneRMI++, groupTwoRMI++)
            items[groupTwoRMI] == ThreeCategories.CATEGORY_2 -> groupTwoRMI++
            items[groupTwoRMI] == ThreeCategories.CATEGORY_3 -> items.swap(groupTwoRMI, groupThreeLMI--)
        }
    }

    return items
}

// reorder the array such that
// items can be in one of four categories
fun variant2(items: Array<FourCategories>): Array<FourCategories> {
    var group1RMI = 0
    var group2RMI = 0
    var group3LMI = items.size - 1
    var group4LMI = items.size - 1

    while (group2RMI < group3LMI){
        when{
            items[group2RMI] == FourCategories.CATEGORY_1 -> items.swap(group2RMI++, group1RMI++)
            items[group2RMI] == FourCategories.CATEGORY_2 -> group2RMI++
            items[group2RMI] == FourCategories.CATEGORY_3 -> items.swap(group2RMI, group3LMI--)
            items[group2RMI] == FourCategories.CATEGORY_4 -> {
                items.swap(group2RMI, group4LMI--)
                items.swap(group2RMI, group3LMI--)
            }

            items[group3LMI] == FourCategories.CATEGORY_3 -> group3LMI--
            items[group3LMI] == FourCategories.CATEGORY_4 -> items.swap(group3LMI--, group4LMI--)
            items[group3LMI] == FourCategories.CATEGORY_2 -> items.swap(group3LMI, group2RMI++)
            items[group3LMI] == FourCategories.CATEGORY_1 -> {
                items.swap(group3LMI, group1RMI++)
                items.swap(group3LMI, group2RMI++)
            }
        }
    }

    return items
}

// sort false category items to be first in the array
fun variant3(items: Array<TwoCategories>): Array<TwoCategories> {
    var firstGroupIndex = 0
    var lastGroupIndex = items.size - 1

    while(firstGroupIndex < lastGroupIndex){
        when{
            items[firstGroupIndex] == TwoCategories.FALSE -> firstGroupIndex++
            else -> items.swap(firstGroupIndex, lastGroupIndex--)
        }
    }

    return items
}

