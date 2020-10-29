package com.example.calculator_dagger_kotlin

import javax.inject.Inject

class Calculator {

    private var addition : Addition
    private  var subtraction: Subtraction
    private  var multiplication: Multiplication
    private  var division: Division

    @Inject
    constructor (addition: Addition, subtraction: Subtraction, multiplication: Multiplication, division: Division) {
        this.addition = addition
        this.subtraction = subtraction
        this.multiplication = multiplication
        this.division = division
    }


    fun addition(operand1: Float, operand2: Float): Float? {
        return addition.getAddition(operand1, operand2)
    }

    fun subtraction(operand1: Float, operand2: Float): Float? {
        return subtraction.getSubtraction(operand1, operand2)
    }

    fun multiplication(operand1: Float, operand2: Float): Float? {
        return multiplication.getMultiplication(operand1, operand2)
    }

    fun division(operand1: Float, operand2: Float): Float? {
        return division.getDivision(operand1, operand2)
    }
}