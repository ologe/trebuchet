package dev.olog.flavor

import dagger.Module
import dev.olog.feature.detail.dagger.FeatureDetailDagger
import dev.olog.feature.login.dagger.FeatureLoginDagger
import dev.olog.feature.main.dagger.FeatureMainDagger

@Module(
    includes = [
        FeatureLoginDagger.AppModule::class,
        FeatureMainDagger.AppModule::class,
        FeatureDetailDagger.AppModule::class
    ]
)
abstract class FlavorModule