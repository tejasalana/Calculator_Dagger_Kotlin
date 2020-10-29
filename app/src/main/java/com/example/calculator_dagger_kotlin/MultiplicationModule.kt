package com.example.calculator_dagger_kotlin

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class MultiplicationModule {

    @Provides
    @Singleton
    fun provideMultiplication(): Multiplication {
        return Multiplication()
    }
}