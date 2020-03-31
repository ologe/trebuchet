package dev.olog.core.dagger

import dev.olog.core.dagger.injectable.Injectable
import dev.olog.core.dagger.injectable.InjectableComponent

/**
 * Interface implemented by [App]
 */
interface SubComponentProvider {
    fun <T : Injectable.Builder<*>> subComponentBuilder(component: InjectableComponent): T
}

/**
 * Allow to get the subcomponent builder from [InjectableComponent]
 */
fun <R : Injectable.Builder<*>> InjectableComponent.subComponentBuilder(): R {
    return (context.applicationContext as SubComponentProvider).subComponentBuilder(this)
}