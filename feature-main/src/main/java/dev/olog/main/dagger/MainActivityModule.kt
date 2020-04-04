package dev.olog.main.dagger

import dagger.Module
import dagger.Provides

@Module
class MainActivityModule {

    @Provides
    fun provideString(): String{
        return "Hello world!"
    }

}