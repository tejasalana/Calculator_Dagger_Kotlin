package com.example.calculator_dagger_kotlin

import android.util.Log

class Division {

    companion object {
        private const val TAG = "teja"
    }

    fun getDivision(operand1: Float, operand2: Float): Float {
        Log.d(TAG, "getDivision: " + this.hashCode())
        return if (operand2 == 0.0f) {
            0.0f
        } else {
            operand1 / operand2
        }
    }
}