package com.example.calculator_dagger_kotlin

import android.util.Log

class Subtraction {
    companion object {
        private const val TAG = "teja"
    }

    fun getSubtraction(operand1: Float, operand2: Float): Float {
        Log.d(TAG, "getSubtraction: " + this.hashCode())
        return operand1 - operand2
    }
}