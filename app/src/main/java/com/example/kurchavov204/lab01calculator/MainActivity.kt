package com.example.kurchavov204.lab01calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.lang.NumberFormatException
import kotlin.math.pow


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

        val twoOperandsHandler = View.OnClickListener { view ->
            var result: Float? = null

            try {
                val a = fieldA?.text.toString().toFloat()
                val b = fieldB?.text.toString().toFloat()

                when (view.id) {
                    R.id.buttonAdd -> result = a + b
                    R.id.buttonSubtract -> result = a - b
                    R.id.buttonMultiply -> result = a * b
                    R.id.buttonDivide -> if (b != 0f) result = a / b
                }

                setResult(result.toString())

            } catch (e: NumberFormatException) {
                setResult(getString(R.string.error_text))
            }
        }

        val oneOperandHandler = View.OnClickListener { view ->
            var result: Float? = null

            try {
                val a = fieldA?.text.toString().toFloat()

                when (view.id) {
                    R.id.buttonSinA -> if (-1 <= a && a <= 1) result = kotlin.math.sin(a)
                    R.id.buttonCosA -> if (-1 <= a && a <= 1) result = kotlin.math.cos(a)
                    R.id.buttonSqrtA -> if (a >= 0) result = kotlin.math.sqrt(a)
                    R.id.buttonSqrA -> result = a.pow(2)
                    R.id.buttonTgA -> result = kotlin.math.tan(a)
                    R.id.buttonCtgA -> result = 1 / kotlin.math.tan(a)
                }

                setResult(result.toString())

            } catch (e: NumberFormatException) {
                setResult(getString(R.string.error_text))
            }
        }

        findViewById<Button>(R.id.buttonAdd).setOnClickListener(twoOperandsHandler)
        findViewById<Button>(R.id.buttonSubtract).setOnClickListener(twoOperandsHandler)
        findViewById<Button>(R.id.buttonMultiply).setOnClickListener(twoOperandsHandler)
        findViewById<Button>(R.id.buttonDivide).setOnClickListener(twoOperandsHandler)

        findViewById<Button>(R.id.buttonSinA).setOnClickListener(oneOperandHandler)
        findViewById<Button>(R.id.buttonCosA).setOnClickListener(oneOperandHandler)

        findViewById<Button>(R.id.buttonSqrtA).setOnClickListener(oneOperandHandler)
        findViewById<Button>(R.id.buttonSqrA).setOnClickListener(oneOperandHandler)
        findViewById<Button>(R.id.buttonTgA).setOnClickListener(oneOperandHandler)
        findViewById<Button>(R.id.buttonCtgA).setOnClickListener(oneOperandHandler)
    }

    private fun setResult(resultTxt: String?) {
        if (resultTxt == null || resultTxt == "null") {
            setResult(getString(R.string.error_text))

        } else {
            resultView?.text = resultTxt
        }
    }
}
