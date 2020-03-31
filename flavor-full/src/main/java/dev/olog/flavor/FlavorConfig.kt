package dev.olog.flavor

import dagger.Module
import dev.olog.detail.DetailScreenDagger
import dev.olog.main.MainScreenDagger
import dev.olog.settings.SettingsScreenDagger

@Module(
    includes = [
        MainScreenDagger.AppModule::class,
        DetailScreenDagger.AppModule::class,
        SettingsScreenDagger.AppModule::class
    ]
)
abstract class FlavorModule

interface FlavorGraph :
    MainScreenDagger.MainScreenGraph,
    DetailScreenDagger.DetailScreenGraph,
    SettingsScreenDagger.SettingsScreenGraph