package dev.olog.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import dev.olog.navigation.extensions.topFragment
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.screens.FragmentScreen
import dev.olog.navigation.transition.setupEnterFadeAnimation
import dev.olog.navigation.transition.setupExitFadeAnimation
import javax.inject.Inject
import javax.inject.Provider

internal class NavigatorImpl @Inject constructor(
    private val activityProvider: ActivityProvider,
    private val intents: Map<ActivityScreen, @JvmSuppressWildcards Provider<Intent>>,
    private val fragments: Map<FragmentScreen, @JvmSuppressWildcards Provider<Fragment>>
) : BaseNavigator(), Navigator {

    override fun toPokedex() {
        navigateTo(FragmentScreen.POKEDEX)
    }

    override fun toMoves() {
        navigateTo(FragmentScreen.MOVES)
    }

    override fun toAbilities() {
        navigateTo(FragmentScreen.ABILITIES)
    }

    override fun toItems() {
        navigateTo(FragmentScreen.ITEMS)
    }

    override fun toLocations() {
        navigateTo(FragmentScreen.LOCATIONS)
    }

    override fun toTypeCharts() {
        navigateTo(FragmentScreen.TYPE_CHARTS)
    }

    private fun navigateTo(screen: FragmentScreen) {
        val activity = activityProvider() ?: return
        activity.supportFragmentManager.topFragment?.setupExitFadeAnimation(activity)

        val fragment = fragments[screen]?.get()
        fragment?.setupEnterFadeAnimation(activity)

        replaceFragment(
            activity = activity,
            fragment = fragment,
            tag = screen.tag
        ) {
            addToBackStack(screen.tag)
        }
    }

    override fun toSettings() {
        val activity = activityProvider() ?: return
        val intent = intents[ActivityScreen.SETTINGS]?.get()
        startActivity(activity, intent)
    }

}