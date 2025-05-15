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