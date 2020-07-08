package dev.olog.lib.image.loader

import android.content.Context
import android.widget.ImageView
import androidx.fragment.app.Fragment

interface LoadRequest {
    fun priority(priority: LoadPriority): LoadRequest
    fun into(view: ImageView)
}

fun Context.loadRequest(url: String?): LoadRequest {
    return GlideLoadRequest(this, url)
}

fun Fragment.loadRequest(url: String?): LoadRequest {
    return requireContext().loadRequest(url)
}