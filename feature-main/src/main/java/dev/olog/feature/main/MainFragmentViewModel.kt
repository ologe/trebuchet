package dev.olog.feature.main

import android.view.View
import androidx.fragment.app.FragmentActivity
import androidx.hilt.lifecycle.ViewModelInject
import androidx.lifecycle.ViewModel
import dev.olog.domain.entity.GithubRepo
import dev.olog.domain.interactor.ObserveRepositoriesUseCase
import dev.olog.domain.interactor.UserLoginUseCase
import dev.olog.navigation.Navigator
import kotlinx.coroutines.flow.Flow

internal class MainFragmentViewModel @ViewModelInject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val navigator: Navigator,
    private val observeRepositoriesUseCase: ObserveRepositoriesUseCase
) : ViewModel() {

    fun observeRepositories(): Flow<List<GithubRepo>> = observeRepositoriesUseCase()

    fun logout(activity: FragmentActivity) {
        userLoginUseCase.logout()
        navigator.toLogin(activity)
    }

    fun navigateToSettings(activity: FragmentActivity) {
        navigator.toSettings(activity)
    }

    fun navigateToDetail(activity: FragmentActivity, repo: GithubRepo, view: View) {
        navigator.toDetail(activity, repo, view)
    }

}