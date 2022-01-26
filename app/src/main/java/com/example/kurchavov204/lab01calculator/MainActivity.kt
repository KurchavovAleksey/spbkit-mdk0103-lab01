package com.example.kurchavov204.lab01calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView


class MainActivity : AppCompatActivity() {
    private var fieldA: EditText? = null
    private var fieldB: EditText? = null
    private var resultView: TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        fieldA = findViewById(R.id.editTextA)
        fieldB = findViewById(R.id.editTextB)
        resultView = findViewById(R.id.textViewResult)

        val onclickListener = View.OnClickListener { view ->
            var a: Float
            var b: Float
            var result: Float? = null

            try {
                 a = fieldA?.text.toString().toFloat()
                 b = fieldB?.text.toString().toFloat()

             } catch (e: NumberFormatException) {
                 this.resultView?.text = getString(R.string.error_text)
                 return@OnClickListener
             }

            when(view.id) {
                R.id.buttonAdd -> result = a + b
                R.id.buttonSubtract -> result = a - b
                R.id.buttonMultiply -> result = a * b
                R.id.buttonDivide ->  {
                    if (b != 0f) {
                        result = a / b
                    }
                }
            }

            if (result == null) {
                resultView?.text = getString(R.string.error_text)
                return@OnClickListener
            }

            resultView?.text = result.toString()

        }

        findViewById<Button>(R.id.buttonAdd).setOnClickListener(onclickListener)
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener(onclickListener)
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener(onclickListener)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(onclickListener)

    }
}
