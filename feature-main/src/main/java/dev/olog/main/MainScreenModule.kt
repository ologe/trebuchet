package dev.olog.main

import dagger.Module
import dagger.Provides

@Module
class MainScreenModule {

    @Provides
    fun provideString(): String{
        return "Hello world!"
    }

}