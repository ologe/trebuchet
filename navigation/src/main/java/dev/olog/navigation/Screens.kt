package dev.olog.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import dagger.MapKey

@MapKey
annotation class ActivityScreenKey(val value: ActivityScreen)

@MapKey
annotation class FragmentScreenKey(val value: FragmentScreen)

typealias FragmentContainer = Class<out Fragment>
internal typealias IntentsMap = Map<ActivityScreen, @JvmSuppressWildcards Intent>
internal typealias FragmentsMap = Map<FragmentScreen, @JvmSuppressWildcards FragmentContainer>

enum class ActivityScreen {
    MAIN,
    DETAIL,
    SETTINGS
}

enum class FragmentScreen {
    DETAIL
}