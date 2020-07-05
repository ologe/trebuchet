package dev.olog.navigation

import android.content.Intent
import androidx.fragment.app.Fragment
import dev.olog.navigation.extensions.getTopFragment
import dev.olog.navigation.screens.ActivityScreen
import dev.olog.navigation.screens.FragmentScreen
import dev.olog.navigation.transition.setupEnterFadeAnimation
import dev.olog.navigation.transition.setupExitFadeAnimation
import javax.inject.Inject
import javax.inject.Provider

internal class NavigatorImpl @Inject constructor(
    private val activityProvider: ActivityProvider,
    private val intents: Map<ActivityScreen, @JvmSuppressWildcards Provider<Intent>>,
    private val fragments: Map<FragmentScreen, @JvmSuppressWildcards Provider<Fragment>>
) : BaseNavigator(), Navigator {

    override fun toHome() {
        val activity = activityProvider() ?: return

        val currentFragment = activity.supportFragmentManager.getTopFragment()
        currentFragment?.setupExitFadeAnimation(activity)

        val fragment = fragments[FragmentScreen.HOME]?.get()
        fragment?.setupEnterFadeAnimation(activity)

        val tag = FragmentScreen.HOME.tag
        replaceFragment(activity, fragment, tag, R.id.fragmentContainer, forced = true) {
            setReorderingAllowed(true)
        }
    }

//    override fun toDetail(activity: FragmentActivity, repo: GithubRepo, view: View) {
//        val currentFragment = activity.supportFragmentManager.getTopFragment()
//        currentFragment?.setupExitSharedAnimation()
//
//        val fragment = fragments[FragmentScreen.DETAIL]?.get()
//        fragment?.arguments = bundleOf(
//            Params.REPO to repo,
//            Params.TRANSITION_NAME to view.transitionName
//        )
//        val tag = FragmentScreen.DETAIL.tag
//        fragment?.setupEnterSharedAnimation(activity)
//        replaceFragment(activity, fragment, tag, R.id.fragmentContainer, forced = false) {
//            setReorderingAllowed(true)
//            addToBackStack(tag)
//            addSharedElement(view, view.transitionName)
//        }
//    }

    override fun toSettings() {
        val activity = activityProvider() ?: return
        val intent = intents[ActivityScreen.SETTINGS]?.get()
        startActivity(activity, intent)
    }

}