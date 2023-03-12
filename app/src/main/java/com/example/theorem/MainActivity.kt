package com.example.theorem

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import com.example.theorem.databinding.ActivityMainBinding
import kotlin.math.pow
import kotlin.math.sqrt

class MainActivity : AppCompatActivity() {
    lateinit var bindingClass: ActivityMainBinding
    override fun onCreate(s: Bundle?) {
        super.onCreate(s)
        bindingClass = ActivityMainBinding.inflate(layoutInflater)
        setContentView(bindingClass.root)
    }

    fun onClickResult(view: View) {
        if (!isFieldEmpty()) {
            val result = getString(R.string.resultInfo) + getResult()
            bindingClass.calculationResult.text = result
        }
    }

    private fun isFieldEmpty(): Boolean {
        bindingClass.apply {
            if (edA.text.isNullOrEmpty()) edA.error = "Поле должно быть заполнено"
            if (edB.text.isNullOrEmpty()) edB.error = "Поле должно быть заполнено"
            return edA.text.isNullOrEmpty() || edB.text.isNullOrEmpty()
        }
    }

    private fun getResult(): String {
        val a: Double
        val b: Double
        bindingClass.apply {
            a = edA.text.toString().toDouble()
            b = edB.text.toString().toDouble()
        }
        return sqrt((a.pow(2) + b.pow(2))).toString()
    }
}