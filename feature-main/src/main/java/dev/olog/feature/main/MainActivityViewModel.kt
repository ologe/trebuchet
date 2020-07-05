package dev.olog.feature.main

import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.olog.navigation.Navigator

internal class MainActivityViewModel @ViewModelInject constructor(
    private val navigator: Navigator
) : ViewModel() {

    fun navigateToMain() {
        navigator.toHome()
    }

}