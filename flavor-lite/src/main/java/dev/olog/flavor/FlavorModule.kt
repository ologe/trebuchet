package dev.olog.flavor

import dagger.Module
import dev.olog.detail.DetailScreenDagger
import dev.olog.main.MainScreenDagger

@Module(
    includes = [
        MainScreenDagger.AppModule::class,
        DetailScreenDagger.AppModule::class
    ]
)
abstract class FlavorModule