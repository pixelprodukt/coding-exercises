package org.coding.ccdschool

import org.example.utils.getLinesFromTextfile

// https://ccd-school.de/coding-dojo/function-katas/csv-tabellieren/
fun createTableFromCsv(fileReader: (String) -> List<String> = ::getLinesFromTextfile) {
    val tableRows = fileReader("ccdschool/people.csv").map { it.split(";") }
    val tableString = generateTableFromData(tableRows)
    println(tableString)
}

private fun generateTableFromData(tableRows: List<List<String>>): String {
    if (tableRows.isEmpty()) return ""

    val headRow = tableRows.first()
    val dataRows = tableRows.drop(1)
    val maxColumnWidths = getMaxColumnWidths(tableRows)

    val headRowString = createRowString(headRow, maxColumnWidths)
    val separatorString = createSeparatorString(maxColumnWidths)
    val dataRowStrings = dataRows.map { row -> createRowString(row, maxColumnWidths) }

    return buildString {
        append(headRowString)
        append(separatorString)
        append(dataRowStrings.joinToString(separator = ""))
    }
}

private fun getMaxColumnWidths(tableRows: List<List<String>>): List<Int> {
    return tableRows.first().indices.map { index ->
        tableRows.maxOf { it[index].length }
    }
}

private fun createRowString(row: List<String>, maxColumnWidths: List<Int>): String {
    return buildString {
        row.forEachIndexed { index, str ->
            append(str.padEnd(maxColumnWidths[index])).append("|")
        }
        append("\n")
    }
}

private fun createSeparatorString(maxColumnWidths: List<Int>): String {
    return buildString {
        maxColumnWidths.forEach { width ->
            append("-".repeat(width)).append("+")
        }
        append("\n")
    }
}
