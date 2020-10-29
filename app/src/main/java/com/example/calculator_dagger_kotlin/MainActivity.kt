package com.example.calculator_dagger_kotlin

import android.annotation.SuppressLint
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import javax.inject.Inject

class MainActivity : AppCompatActivity(), View.OnClickListener {

    @Inject lateinit var calculator: Calculator
    private var num1 : Float = 0.0f
    private var num2 : Float = 0.0f
    private val defaultValue : Float = 0.0f
    private var result : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        if (intent.extras != null ) {
            num1 = intent.getFloatExtra("first_number", 1f)
            num2 = intent.getFloatExtra("second_number", 1f)
            editText1.setText(num1.toString())
            editText2.setText(num2.toString())
        }

        //calculator  = Calculator( Addition(), Subtraction(), Multiplication(), Division())
        val calculatorComponent : CalculatorComponent = (application as CalculatorApplication).getCalculatorComponent()
        calculatorComponent.fieldInject(this)
        //calculator = calculatorComponent.getCalculator()

        addBtn.setOnClickListener(this)
        subBtn.setOnClickListener(this)
        nextBtn.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view : View?) {

        num1 = if (editText1.text.toString() == "") defaultValue else editText1.text.toString().toFloat()
        num2 = if (editText2.text.toString() == "") defaultValue else editText2.text.toString().toFloat()

        if (view != null) {

            when (view.id) {
                R.id.addBtn -> {

                    result = calculator.addition(num1, num2)!!
                    textView.text = "Addition is: $result"

                }
                R.id.subBtn -> {

                    result = calculator.subtraction(num1, num2)!!
                    textView.text = "Subtraction is: $result"

                }
                else -> {

                    val intent = Intent(this@MainActivity, SecondActivity::class.java)
                    intent.putExtra("first_number", num1)
                    intent.putExtra("second_number", num2)
                    startActivity(intent)
                }
            }

        }
    }

}