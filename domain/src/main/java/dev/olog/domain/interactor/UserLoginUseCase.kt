package dev.olog.domain.interactor

import dev.olog.domain.entity.User
import dev.olog.domain.gateway.UserGateway
import javax.inject.Inject

class UserLoginUseCase @Inject constructor(
    private val gateway: UserGateway
) {

    fun isLogged(): Boolean = gateway.isLogged()

    fun login(user: User) {
        gateway.login(user)
    }

    fun logout() {
        gateway.logout()

    }

}