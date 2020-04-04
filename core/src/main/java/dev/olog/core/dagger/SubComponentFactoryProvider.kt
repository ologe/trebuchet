package dev.olog.core.dagger

import android.content.Context
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent

/**
 * Interface implemented by [App]
 */
interface SubComponentFactoryProvider {
    fun <T : Injectable.Factory> daggerFactory(component: InjectableComponent): T
}

/**
 * Allow to get the subcomponent builder from [InjectableComponent]
 */
fun <R : Injectable.Factory> InjectableComponent.daggerFactory(context: Context): R {
    return (context.applicationContext as SubComponentFactoryProvider)
        .daggerFactory(this)
}