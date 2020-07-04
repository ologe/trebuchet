package dev.olog.feature.main

import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.olog.domain.interactor.UserLoginUseCase
import dev.olog.navigation.Navigator

internal class MainActivityViewModel @ViewModelInject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val navigator: Navigator
) : ViewModel() {

    fun isLogged() = userLoginUseCase.isLogged()

    fun navigateToLogin(activity: FragmentActivity) {
        navigator.toLogin(activity)
    }

    fun navigateToMain(activity: FragmentActivity) {
        navigator.toMain(activity)
    }

}