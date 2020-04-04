package dev.olog.flavor

import dagger.Module
import dev.olog.detail.dagger.DetailScreenDagger
import dev.olog.main.dagger.FeatureMainDagger
import dev.olog.settings.dagger.FeatureSettingsDagger

// TODO find a way to avoid this
@Module(
    includes = [
        FeatureMainDagger.AppModule::class,
        DetailScreenDagger.AppModule::class,
        FeatureSettingsDagger.AppModule::class
    ]
)
abstract class FlavorModule