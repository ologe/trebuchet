package dev.olog.core.dagger.injectable

import android.content.Context

/**
 * Implement this interface if you want to have a subcomponent
 * [context] is here as a helper (can be removed, but then you have to pass the context to [InjectableComponent.subComponentBuilder]
 */
interface InjectableComponent {
    val context: Context
}