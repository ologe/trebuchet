package dev.olog.navigation

import android.view.View
import androidx.fragment.app.FragmentActivity
import dev.olog.domain.entity.GithubRepo

interface Navigator {

    fun FragmentActivity.toLogin()

    fun FragmentActivity.toMain()

    fun FragmentActivity.toDetail(repo: GithubRepo, view: View)

    fun FragmentActivity.toSettings()

}