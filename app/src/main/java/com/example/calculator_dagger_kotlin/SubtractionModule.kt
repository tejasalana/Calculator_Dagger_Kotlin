package com.example.calculator_dagger_kotlin

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class SubtractionModule {

    @Provides
    @Singleton
    fun provideSubtraction(): Subtraction {
        return Subtraction()
    }
}