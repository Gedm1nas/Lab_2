package com.example.lab_2

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.*
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat

class MainActivity : AppCompatActivity() {
    lateinit var tvResult: TextView
    lateinit var edUserInput: EditText
    lateinit var spinner: Spinner

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)

        tvResult = findViewById(R.id.tvCountResult)
        edUserInput = findViewById(R.id.edUserInput)
        spinner = findViewById(R.id.spSelectionOptions)

        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        ArrayAdapter.createFromResource(
            this,
            R.array.count_Options,
            android.R.layout.simple_spinner_item
        ).also { adapter ->
            adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item)
            spinner.adapter = adapter
        }
    }

    fun onBtnCountClick(view: View) {
        val userPhrase: String = edUserInput.text.toString()
        if (userPhrase.isEmpty()) {
            Toast.makeText(this, R.string.empty_input_message, Toast.LENGTH_SHORT).show()
            return
        }

        val selectedOption = spinner.selectedItem.toString()
        val result = when (selectedOption) {
            "Words" -> TextCounter.getWordsCount(userPhrase)
            "Chars" -> TextCounter.getCharsCount(userPhrase)
            else -> 0
        }

        Log.d("MainActivity", "User input: $userPhrase, Result: $result")
        tvResult.text = result.toString()
    }
}
