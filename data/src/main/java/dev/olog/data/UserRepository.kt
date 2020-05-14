package dev.olog.data

import android.content.Context
import dev.olog.core.dagger.ApplicationContext
import dev.olog.data.utils.observeKey
import dev.olog.domain.entity.User
import dev.olog.domain.gateway.UserGateway
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import javax.inject.Inject

internal class UserRepository @Inject constructor(
    @ApplicationContext context: Context
) : UserGateway {

    companion object {
        private const val USER = "github_user"
        private const val PASSWORD = "github_password"
    }

    private val prefs = context.getSharedPreferences("prefs", Context.MODE_PRIVATE)

    override fun isLogged(): Boolean {
        return prefs.contains(USER) && prefs.contains(PASSWORD)
    }

    override fun login(user: User) {
        prefs.edit()
            .putString(USER, user.username)
            .putString(PASSWORD, user.password)
            .apply()
    }

    override fun logout() {
        prefs.edit()
            .remove(USER)
            .remove(PASSWORD)
            .apply()
    }

    override fun observe(): Flow<User> {
        return prefs.observeKey(USER, "")
            .combine(prefs.observeKey(PASSWORD, "")) { username, password ->
                User(username, password)
            }
    }
}