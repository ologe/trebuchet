package dev.olog.flavor

import dagger.Module
import dev.olog.detail.dagger.DetailScreenDagger
import dev.olog.main.dagger.FeatureMainDagger

@Module(
    includes = [
        FeatureMainDagger.AppModule::class,
        DetailScreenDagger.AppModule::class
    ]
)
abstract class FlavorModule