package com.example.calculator_dagger_kotlin

import android.util.Log

class Addition {

    companion object {
        private const val TAG = "teja"
    }

    fun getAddition(operand1: Float, operand2: Float): Float {
        Log.d(TAG, "getAddition: " + this.hashCode())
        return operand1 + operand2
    }

}