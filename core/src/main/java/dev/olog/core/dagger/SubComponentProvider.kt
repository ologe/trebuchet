package dev.olog.core.dagger

import android.content.Context
import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent

/**
 * Interface implemented by [App]
 */
interface SubComponentProvider {
    fun <T : Injectable.Factory> subComponentBuilder(component: InjectableComponent): T
}

/**
 * Allow to get the subcomponent builder from [InjectableComponent]
 */
fun <R : Injectable.Factory> InjectableComponent.subComponentBuilder(context: Context): R {
    return (context.applicationContext as SubComponentProvider).subComponentBuilder(this)
}