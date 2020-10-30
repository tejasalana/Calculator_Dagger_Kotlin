package com.example.calculator_dagger_kotlin

import dagger.Component
import javax.inject.Singleton

@Component(modules = [AdditionModule::class, SubtractionModule::class, MultiplicationModule::class, DivisionModule::class])
@Singleton
interface CalculatorComponent {

    fun fieldInject(mainActivity: MainActivity)
    fun fieldInject(secondActivity: SecondActivity)

    //fun getCalculator() : Calculator
}