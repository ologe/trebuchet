package dev.olog.navigation.transition

import android.content.Context
import androidx.fragment.app.Fragment
import com.google.android.material.transition.MaterialFadeThrough
import com.google.android.material.transition.MaterialSharedAxis
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

fun Fragment.setupExitSharedAxisAnimation(
    context: Context,
    @MaterialSharedAxis.Axis axis: Int
) {
    reenterTransition = MaterialSharedAxis(axis, false).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    exitTransition = MaterialSharedAxis(axis, true).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
}

fun Fragment.setupEnterSharedAxisAnimation(
    context: Context,
    @MaterialSharedAxis.Axis axis: Int
) {
    enterTransition = MaterialSharedAxis(axis, true).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
    returnTransition = MaterialSharedAxis(axis, false).apply {
        duration = context.resources.getInteger(R.integer.transition_default_duration).toLong()
    }
}