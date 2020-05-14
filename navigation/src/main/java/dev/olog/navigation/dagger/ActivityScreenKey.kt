package dev.olog.navigation.dagger

import dagger.MapKey
import dev.olog.navigation.screens.ActivityScreen

@Target(AnnotationTarget.FUNCTION)
@MapKey
annotation class ActivityScreenKey(val value: ActivityScreen)