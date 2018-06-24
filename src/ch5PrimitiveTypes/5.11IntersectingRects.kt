package ch5PrimitiveTypes

import kotlin.math.max
import kotlin.math.min

fun main(args: Array<String>) {
    // test if two rectangles intersect, if they do return the intersecting rectangle
    // assume that if only sides are touching there is no intersection

    val rect1 = Rect(0, 2, 0, 2)
    val rect2 = Rect(1, 4, 1, 4)
    println(rect1.doesIntersect(rect2))
    println(rect1.intersectedRect(rect2))
}

data class Rect(val x: Int,
                val width: Int,
                val y: Int,
                val height: Int){

    fun doesIntersect(other: Rect): Boolean{
        return x + width > other.x && y + height < other.y + height
    }

    fun intersectedRect(other: Rect): Rect{
        return Rect(x = max(x, other.x),
                width = min(x + width, other.x + width) - max(x, other.x),
                y = max(y, other.y),
                height = min(y + height, other.y + height) - max(y, other.y))
    }
}

