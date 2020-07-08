package dev.olog.navigation.transition

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import dev.olog.navigation.R

fun Fragment.setupExitFadeAnimation(context: Context) {
    val transition = MaterialFadeThrough().apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    exitTransition = transition
    reenterTransition = transition
}

fun Fragment.setupEnterFadeAnimation(context: Context) {
    val transition = MaterialFadeThrough().apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    enterTransition = transition
    returnTransition = transition
}