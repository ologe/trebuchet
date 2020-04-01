package dev.olog.trebuchet

import android.app.Application
import dev.olog.core.dagger.SubComponentProvider
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.injectable.InjectableComponentsMap
import javax.inject.Inject

class App : Application(), SubComponentProvider {

    @Inject
    lateinit var multibinds: InjectableComponentsMap

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Injectable.Factory<*>> subComponentBuilder(
        component: InjectableComponent
    ): T {
        return multibinds[component::class.java] as T
    }
}