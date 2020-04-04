package dev.olog.core.dagger.injectable

/**
 * Base class for [dagger.Subcomponent] and [dagger.Subcomponent.Factory]
 */
interface Injectable<Component : InjectableComponent> {

    fun inject(instance: Component)

    interface Factory

}