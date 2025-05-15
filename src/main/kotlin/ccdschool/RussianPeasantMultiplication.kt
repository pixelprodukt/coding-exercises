package org.coding.ccdschool

// https://ccd-school.de/coding-dojo/function-katas/russische-bauernmultiplikation/
fun multiplyAfterRussianPeasantMethod(a: Int, b: Int): Int {
    var valueA = a
    var valueB = b
    val valuesToSum: MutableList<Int> = mutableListOf()

    while (valueA > 0) {
        if (valueA % 2 != 0) {
            valuesToSum.add(valueB)
        }

        valueA = valueA / 2
        valueB = valueB * 2
    }

    return valuesToSum.sum()
}

// Optimized version from chatGpt
fun multiplyAfterRussianPeasantMethodChatGpt(a: Int, b: Int): Int {
    var valueA = a
    var valueB = b
    var result = 0

    while (valueA > 0) {
        if (valueA and 1 == 1) { // equivalent to valueA % 2 != 0
            result += valueB
        }

        valueA = valueA shr 1  // equivalent to valueA / 2, shifts the bit pattern one to the right
        valueB = valueB shl 1  // equivalent to valueB * 2, shifts the bit pattern one to the left
    }

    return result
}