package dev.olog.lib.image.loader

import android.content.Context
import android.widget.ImageView
import com.bumptech.glide.Glide

internal class GlideLoadRequest(
    context: Context,
    url: String?
) : LoadRequest {

    private var builder = Glide.with(context)
        .load(url)

    override fun priority(priority: LoadPriority): LoadRequest {
        builder = builder.priority(priority.toGlide())
        return this
    }

    override fun into(view: ImageView) {
        builder.into(view)
    }
}