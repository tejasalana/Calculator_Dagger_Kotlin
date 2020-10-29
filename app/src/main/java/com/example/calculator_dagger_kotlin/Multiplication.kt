package com.example.calculator_dagger_kotlin

import android.util.Log

class Multiplication {

    companion object {
        private const val TAG = "teja"
    }

    fun getMultiplication(operand1: Float, operand2: Float): Float {
        Log.d(TAG, "getMultiplication: " + this.hashCode())
        return operand1 * operand2
    }
}