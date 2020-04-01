package dev.olog.core.dagger.injectable

import dagger.MapKey
import kotlin.reflect.KClass

/**
 * Base class for Components and Components.Builder
 */
interface Injectable<Component : InjectableComponent> {

    fun inject(instance: Component)

    interface Factory<InjectableComponent : Injectable<*>>

}

/**
 * Implement this interface if you want to have a subcomponent
 */
interface InjectableComponent

@MapKey
annotation class InjectableKey(val value: KClass<out InjectableComponent>)

typealias InjectableComponentsMap = Map<Class<out InjectableComponent>, @JvmSuppressWildcards Injectable.Factory<*>>