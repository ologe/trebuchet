package dev.olog.feature.main

import androidx.fragment.app.FragmentActivity
import dev.olog.domain.interactor.UserLoginUseCase
import dev.olog.navigation.Navigator
import javax.inject.Inject

internal class MainActivityController @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val navigator: Navigator
) {

    fun isLogged() = userLoginUseCase.isLogged()

    fun navigateToLogin(activity: FragmentActivity) {
        navigator.toLogin(activity)
    }

    fun navigateToMain(activity: FragmentActivity) {
        navigator.toMain(activity)
    }

}