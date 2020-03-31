package dev.olog.core.dagger.injectable

import dagger.MapKey
import dev.olog.core.dagger.injectable.InjectableComponent
import kotlin.reflect.KClass

@Target(
    AnnotationTarget.FUNCTION,
    AnnotationTarget.PROPERTY_GETTER,
    AnnotationTarget.PROPERTY_SETTER
)
@Retention(AnnotationRetention.RUNTIME)
@MapKey
annotation class InjectableKey (val value: KClass<out InjectableComponent>)