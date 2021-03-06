package dev.olog.navigation.impl

import androidx.fragment.app.Fragment
import dev.olog.domain.entity.Pokemon
import dev.olog.feature.android.withArguments
import dev.olog.navigation.utils.ActivityProvider
import dev.olog.navigation.Navigator
import dev.olog.navigation.Params
import dev.olog.navigation.utils.topFragment
import dev.olog.navigation.screens.FragmentScreen
import dev.olog.navigation.transition.setupEnterFadeAnimation
import dev.olog.navigation.transition.setupExitFadeAnimation
import javax.inject.Inject
import javax.inject.Provider

internal class NavigatorImpl @Inject constructor(
    private val activityProvider: ActivityProvider,
    private val fragments: Map<FragmentScreen, @JvmSuppressWildcards Provider<Fragment>>
) : BaseNavigator(),
    Navigator {

    override fun toPokedex() {
        navigateTo(FragmentScreen.POKEDEX)
    }

    override fun toPokedexDetail(pokemon: Pokemon) {
        val activity = activityProvider() ?: return
        activity.supportFragmentManager.topFragment?.setupExitFadeAnimation(activity)

        val screen = FragmentScreen.POKEDEX_DETAIL
        val fragment = fragments[screen]?.get()?.withArguments(
            Params.POKEMON to pokemon
        )
        fragment?.setupEnterFadeAnimation(activity)

        replaceFragment(
            activity = activity,
            fragment = fragment,
            tag = screen.tag
        ) {
            addToBackStack(screen.tag)
        }
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

    override fun toNews() {
        navigateTo(FragmentScreen.NEWS)
    }

    override fun toSearch() {
        navigateTo(FragmentScreen.SEARCH)
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

}