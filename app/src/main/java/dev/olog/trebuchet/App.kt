package dev.olog.trebuchet

import android.app.Application
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent
import dev.olog.core.dagger.SubComponentProvider
import javax.inject.Inject

class App : Application(), SubComponentProvider {

    @Inject
    lateinit var multibinds: Map<Class<out InjectableComponent>, @JvmSuppressWildcards Injectable.Builder<*>>

    override fun onCreate() {
        super.onCreate()

        DaggerAppComponent.factory()
            .create(this)
            .inject(this)
    }

    @Suppress("UNCHECKED_CAST")
    override fun <T : Injectable.Builder<*>> subComponentBuilder(
        component: InjectableComponent
    ): T {
        return multibinds[component::class.java] as T
    }
}