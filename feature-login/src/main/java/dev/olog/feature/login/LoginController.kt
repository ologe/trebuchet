package dev.olog.feature.login

import androidx.fragment.app.Fragment
import dev.olog.domain.entity.User
import dev.olog.domain.interactor.UserLoginUseCase
import dev.olog.navigation.Navigator
import javax.inject.Inject

class LoginController @Inject constructor(
    private val userLoginUseCase: UserLoginUseCase,
    private val navigator: Navigator
) {

    fun Fragment.login(username: String, password: String) {
        userLoginUseCase.login(User(username, password))
        with(navigator) {
            requireActivity().toMain()
        }
    }

}