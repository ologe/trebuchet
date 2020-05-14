package dev.olog.trebuchet

import dagger.Component
import dagger.android.AndroidInjectionModule
import dagger.android.AndroidInjector
import dev.olog.data.DataModule
import dev.olog.flavor.FlavorModule
import dev.olog.navigation.NavigationModule
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        FlavorModule::class,

        // data
        DataModule::class,

        // features
        NavigationModule::class,
        AndroidInjectionModule::class
    ]
)
@Singleton
interface AppComponent : AndroidInjector<App> {

    @Component.Factory
    interface Factory : AndroidInjector.Factory<App>

}