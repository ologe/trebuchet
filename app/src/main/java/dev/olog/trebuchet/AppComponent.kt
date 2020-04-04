package dev.olog.trebuchet

import dagger.BindsInstance
import dagger.Component
import dev.olog.flavor.FlavorModule
import dev.olog.navigation.NavigationModule
import javax.inject.Singleton

@Component(
    modules = [
        AppModule::class,
        FlavorModule::class,
        NavigationModule::class
    ]
)
@Singleton
interface AppComponent {

    fun inject(app: App)

    @Component.Factory
    interface Factory {

        fun create(@BindsInstance app: App): AppComponent

    }

}