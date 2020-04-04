package dev.olog.core.dagger.injectable

import dagger.MapKey
import kotlin.reflect.KClass

@MapKey
annotation class InjectableKey(val value: KClass<out InjectableComponent>)