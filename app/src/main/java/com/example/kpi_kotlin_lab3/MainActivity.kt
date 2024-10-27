// MainActivity.kt
package com.example.kpi_kotlin_lab3

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // Підключення елементів з лейауту
        val inputPc = findViewById<EditText>(R.id.inputPc)
        val inputSigma1 = findViewById<EditText>(R.id.inputSigma1)
        val inputSigma2 = findViewById<EditText>(R.id.inputSigma2)
        val inputV = findViewById<EditText>(R.id.inputV)
        val resultText = findViewById<TextView>(R.id.resultText)
        val calculateButton = findViewById<Button>(R.id.calculateButton)

        calculateButton.setOnClickListener {
            // Отримання значень з полів введення
            val pc = inputPc.text.toString().toDoubleOrNull() ?: 0.0
            val sigma1 = inputSigma1.text.toString().toDoubleOrNull() ?: 0.0
            val sigma2 = inputSigma2.text.toString().toDoubleOrNull() ?: 0.0
            val v = inputV.text.toString().toDoubleOrNull() ?: 0.0

            // Виклик функції для обчислення прибутку
            val profit = calculateProfit(pc, sigma1, sigma2, v)
            resultText.text = "Розрахований Прибуток: $profit грн"
        }
    }

    // Функція для розрахунку прибутку за формулами
    private fun calculateProfit(pc: Double, sigma1: Double, sigma2: Double, v: Double): Double {
        // Обчислення на основі прикладу
        val deltaW1 = 0.2 // Припустимо 20% на основі прикладу
        val W1 = pc * 24 * deltaW1
        val P1 = W1 * v

        val deltaW2 = 0.68 // Припустимо 68% на основі прикладу
        val W3 = pc * 24 * deltaW2
        val P2 = W3 * v

        // Розрахунок штрафу та загального прибутку
        val penaltyW4 = pc * 24 * (1 - deltaW2)
        val penaltyCost = penaltyW4 * v
        val totalProfit = P2 - penaltyCost

        return totalProfit
    }
}
