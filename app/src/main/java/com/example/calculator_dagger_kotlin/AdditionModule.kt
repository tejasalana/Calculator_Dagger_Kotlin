package com.example.calculator_dagger_kotlin

import dagger.Module
import dagger.Provides
import javax.inject.Singleton

@Module
class AdditionModule {
    @Provides
    @Singleton
    fun provideAddition(): Addition {
        return Addition()
    }
}