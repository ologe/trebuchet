package dev.olog.feature.android

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.annotation.LayoutRes

fun ViewGroup.inflate(
    @LayoutRes layoutRes: Int,
    attachToRoot: Boolean = false
): View {
    val inflater = LayoutInflater.from(context)
    return inflater.inflate(layoutRes, this, attachToRoot)
}