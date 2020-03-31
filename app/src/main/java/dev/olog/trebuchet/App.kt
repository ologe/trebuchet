package dev.olog.trebuchet

import android.app.Application
import dev.olog.core.dagger.SubComponentProvider
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import javax.inject.Inject

class App : Application(), SubComponentProvider {

    @Inject
    lateinit var multibinds: Map<Class<out InjectableComponent>, @JvmSuppressWildcards Injectable.Factory<*>>

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