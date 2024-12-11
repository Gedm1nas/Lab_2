package com.example.lab_2.utils
import com.example.lab_2.TextCounter
import org.junit.Assert.assertEquals
import org.junit.Test

class TextCounterTest {
    @Test
    fun getWordsCountshouldReturnCorrectCount() {
        val input = "This is a test sentence."
        val expectedCount = 5
        val actualCount = TextCounter.getWordsCount(input)
        assertEquals(expectedCount, actualCount)
    }

    @Test
    fun getCharsCountshouldReturnCorrectCount() {
        val input = "This is a test sentence."
        val expectedCount = 24
        val actualCount = TextCounter.getCharsCount(input)
        assertEquals(expectedCount, actualCount)
    }

}