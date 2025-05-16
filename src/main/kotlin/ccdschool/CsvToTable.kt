package org.coding.ccdschool

import org.example.utils.getLinesFromTextfile

// https://ccd-school.de/coding-dojo/function-katas/csv-tabellieren/
fun createTableFromCsv() {
    val tableRows = getLinesFromTextfile("ccdschool/people.csv").map { line -> line.split(";") }

    println("tableRows: $tableRows")
    println("maxColumnWidths: ${getMaxColumnWidths(tableRows)}")
}

private fun getMaxColumnWidths(tableRows: List<List<String>>): List<Int> {
    return tableRows.first().indices.map { index ->
        var maxSize = 0
        tableRows.forEach { row -> if (maxSize < row[index].length) maxSize = row[index].length }
        maxSize
    }
}

