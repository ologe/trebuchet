package dev.olog.lib.image.loader

import com.bumptech.glide.Priority

enum class LoadPriority {
    LOW,
    NORMAL,
    HIGH
}

internal fun LoadPriority.toGlide(): Priority = when (this) {
    LoadPriority.LOW -> Priority.LOW
    LoadPriority.NORMAL -> Priority.NORMAL
    LoadPriority.HIGH -> Priority.HIGH
}