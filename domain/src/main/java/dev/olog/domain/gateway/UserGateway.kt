package dev.olog.domain.gateway

import dev.olog.domain.entity.User
import kotlinx.coroutines.flow.Flow

interface UserGateway {

    fun isLogged(): Boolean

    fun login(user: User)

    fun logout()

    fun observe(): Flow<User>

}