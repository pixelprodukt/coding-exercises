package org.coding

import org.coding.ccdschool.multiplyAfterRussianPeasantMethod
import org.example.dayone.ExtractNumbersFromTextlinesParser
import org.example.daythree.MachinePartNumberFinder
import org.example.daytwo.CubeDataAnalyzer

fun main() {
    val sumOfDayOne = ExtractNumbersFromTextlinesParser("input_day_one.txt").getSumOfAllLines()
    println(sumOfDayOne)

    val cubeDataAnalyzer = CubeDataAnalyzer("input_day_two.txt")

    val machinePartNumberFinder = MachinePartNumberFinder("input_day_three.txt")

    val sum = multiplyAfterRussianPeasantMethod(42, 47)
    println("sum of all b values: $sum")
}