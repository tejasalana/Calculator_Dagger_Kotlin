package com.example.calculator_dagger_kotlin

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class DivisionModule {

    @Provides
    @Singleton
    fun provideDivision(): Division {
        return Division()
    }
}