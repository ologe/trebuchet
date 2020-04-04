package dev.olog.trebuchet

import android.app.Application
import dev.olog.core.dagger.SubComponentFactoryProvider
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.injectable.InjectableComponentMap
import javax.inject.Inject

class App : Application(), SubComponentFactoryProvider {

    @Inject
    internal lateinit var componentFactoryMap: InjectableComponentMap

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Injectable.Factory> daggerFactory(
        component: InjectableComponent
    ): T {
        return componentFactoryMap[component::class.java] as T
    }
}