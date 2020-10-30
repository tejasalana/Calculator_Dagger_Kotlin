package com.example.calculator_dagger_kotlin

import android.app.Application

class CalculatorApplication : Application() {

    private lateinit var calculatorComponent : CalculatorComponent

    override fun onCreate() {
        calculatorComponent = DaggerCalculatorComponent.create()
        super.onCreate()
    }

    fun getCalculatorComponent() : CalculatorComponent{
        return calculatorComponent
    }

}