package dev.olog.feature.main.home

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.olog.navigation.Navigator

internal class HomeFragmentViewModel @ViewModelInject constructor(
    private val navigator: Navigator
) : ViewModel() {

    val data: List<HomeFragmentModel> = listOf(
        HomeFragmentModel.Search
    )

    fun navigateToPokedex() {
        navigator.toPokedex()
    }

    fun navigateToMoves() {
        navigator.toMoves()
    }

    fun navigateToAbilities() {
        navigator.toAbilities()
    }

    fun navigateToItems() {
        navigator.toItems()
    }

    fun navigateToLocations() {
        navigator.toLocations()
    }

    fun navigateToTypeCharts() {
        navigator.toTypeCharts()
    }

}