package dev.olog.feature.main

import android.view.View
import androidx.fragment.app.Fragment
import dev.olog.domain.entity.GithubRepo
import dev.olog.domain.interactor.ObserveRepositoriesUseCase
import dev.olog.domain.interactor.UserLoginUseCase
import dev.olog.navigation.Navigator
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

internal class MainFragmentController @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val navigator: Navigator,
    private val observeRepositoriesUseCase: ObserveRepositoriesUseCase
) {

    fun observeRepositories(): Flow<List<GithubRepo>> = observeRepositoriesUseCase()

    fun Fragment.logout() {
        userLoginUseCase.logout()
        with(navigator) { requireActivity().toLogin() }
    }

    fun Fragment.navigateToSettings() = with(navigator) { requireActivity().toSettings() }

    fun Fragment.navigateToDetail(repo: GithubRepo, view: View) = with(navigator) {
        requireActivity().toDetail(repo, view)
    }

}