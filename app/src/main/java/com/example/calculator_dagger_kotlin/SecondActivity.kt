package com.example.calculator_dagger_kotlin

import android.annotation.SuppressLint
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_second.*
import javax.inject.Inject

class SecondActivity : AppCompatActivity(), View.OnClickListener {

    @Inject lateinit var calculator: Calculator
    private var num1 : Float = 0.0f
    private var num2 : Float = 0.0f
    private var result : Float = 0.0f

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_second)

        val intent = intent
        if (intent != null && intent.extras != null) {
            num1 = intent.getFloatExtra("first_number", 0.0f)
            num2 = intent.getFloatExtra("second_number", 0.0f)
        } else {
            throw ActivityNotFoundException("Insufficient Intent Extras for Second Activity.....")
        }

        //calculator  = Calculator( Addition(), Subtraction(), Multiplication(), Division())
        val calculatorComponent : CalculatorComponent = (application as CalculatorApplication).getCalculatorComponent()
        calculatorComponent.fieldInject(this)
        //calculator = calculatorComponent.getCalculator()

        mulBtn.setOnClickListener(this)
        divBtn.setOnClickListener(this)
        backBtn.setOnClickListener(this)
    }

    @SuppressLint("SetTextI18n")
    override fun onClick(view : View?) {

        if (view != null) {
            when (view.id) {
                R.id.mulBtn -> {

                    result = calculator.multiplication(num1, num2)!!
                    textView.text = "Multiplication is: $result"

                }
                R.id.divBtn -> {

                    result = calculator.division(num1, num2)!!
                    textView.text = "Division is: $result"

                }
                else -> {

                    val intent = Intent(this@SecondActivity, MainActivity::class.java)
                    intent.putExtra("first_number", num1)
                    intent.putExtra("second_number", num2)
                    startActivity(intent)

                }
            }
        }
        }

}