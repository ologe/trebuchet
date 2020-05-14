package dev.olog.navigation

import android.view.View
import androidx.fragment.app.FragmentActivity
import dev.olog.domain.entity.GithubRepo

interface Navigator {

    fun toLogin(activity: FragmentActivity)

    fun toMain(activity: FragmentActivity)

    fun toDetail(activity: FragmentActivity, repo: GithubRepo, view: View)

    fun toSettings(activity: FragmentActivity)

}