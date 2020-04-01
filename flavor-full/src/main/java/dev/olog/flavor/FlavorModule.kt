package dev.olog.flavor

import dagger.Module
import dev.olog.detail.DetailScreenDagger
import dev.olog.main.MainScreenDagger
import dev.olog.settings.SettingsScreenDagger

// TODO find a way to avoid this
@Module(
    includes = [
        MainScreenDagger.AppModule::class,
        DetailScreenDagger.AppModule::class,
        SettingsScreenDagger.AppModule::class
    ]
)
abstract class FlavorModule