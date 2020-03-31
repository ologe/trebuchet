package dev.olog.core.dagger.injectable

/**
 * Base class for Components and Components.Builder
 */
interface Injectable<Component : InjectableComponent> {

    fun inject(instance: Component)

    interface Builder<InjectableComponent : Injectable<*>> {
        fun build(): InjectableComponent
    }

}