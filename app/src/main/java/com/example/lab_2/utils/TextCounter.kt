package com.example.lab_2

object TextCounter {
    fun getCharsCount(input: String): Int {
        return input.length
    }

    fun getWordsCount(input: String): Int {
        return input.split(Regex("[\\s,\\.]+")).filter { it.isNotEmpty() }.size
    }
}