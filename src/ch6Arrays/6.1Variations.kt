package ch6Arrays

enum class ThreeCategories {
    CATEGORY_1, CATEGORY_2, CATEGORY_3
}

enum class FourCategories {
    CATEGORY_1, CATEGORY_2, CATEGORY_3, CATEGORY_4
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
}

// sort an array such that elements wit the same category appear together
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

