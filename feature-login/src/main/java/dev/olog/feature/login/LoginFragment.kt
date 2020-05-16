package dev.olog.feature.login

import android.os.Bundle
import android.view.View
import dagger.android.support.DaggerFragment
import kotlinx.android.synthetic.main.fragment_login.*
import javax.inject.Inject

class LoginFragment : DaggerFragment(R.layout.fragment_login) {

    @Inject
    lateinit var controller: LoginController

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        login.setOnClickListener {
            if (username.text.isNotBlank() && password.text.isNotBlank()) {
                with(controller) {
                    login(
                        username.text.toString(),
                        password.text.toString()
                    )
                }
            }
        }
    }

}