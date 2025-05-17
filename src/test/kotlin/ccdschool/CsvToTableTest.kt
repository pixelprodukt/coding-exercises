package ccdschool

import org.coding.ccdschool.createTableFromCsv
import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import java.io.ByteArrayOutputStream
import java.io.PrintStream

class CsvToTableTest {

    @Test
    fun `createTableFromCsv prints formatted table from CSV`() {
        val fakeCsvLines = listOf("Name;Age", "Alice;30", "Bob;25")
        val mockFileReader: (String) -> List<String> = { _ -> fakeCsvLines }

        val outputStream = ByteArrayOutputStream()
        System.setOut(PrintStream(outputStream))

        createTableFromCsv(mockFileReader)

        val expectedOutput = """
            Name |Age|
            -----+---+
            Alice|30 |
            Bob  |25 |
        """.trimIndent()

        val actualOutput = outputStream.toString().trim()
        assertEquals(expectedOutput, actualOutput)
    }
}