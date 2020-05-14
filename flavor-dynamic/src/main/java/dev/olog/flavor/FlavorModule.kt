package dev.olog.flavor
import dagger.Module
@Module(
    includes = [
        dev.olog.feature.main.dagger.FeatureMainDagger.AppModule::class
    ]
)
class FlavorModule