package com.example.calculator_dagger_kotlin

import android.app.Application

class CalculatorApplication : Application() {

    private lateinit var calculatorComponent : CalculatorComponent

    override fun onCreate() {
        super.onCreate()
        calculatorComponent = DaggerCalculatorComponent.create()

    }

    fun getCalculatorComponent() : CalculatorComponent{
        return calculatorComponent
    }

}