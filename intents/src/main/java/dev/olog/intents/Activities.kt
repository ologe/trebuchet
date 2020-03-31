package dev.olog.intents

import android.app.Activity
import android.content.Context
import android.content.Intent
import androidx.core.os.bundleOf

object Activities {

    // unit tested in :app
    const val DETAIL_CLASS = "dev.olog.detail.DetailActivity"
    const val SETTINGS_CLASS = "dev.olog.settings.SettingsActivity"

    fun toDetail(context: Context, listingId: Int): Intent? {
        val args = bundleOf(
            Params.LISTING_ID to listingId
        )

        return loadClassOrNull<Activity>(DETAIL_CLASS)
            ?.let { Intent(context, it) }
            ?.apply { putExtras(args) }
    }

    fun toSettings(context: Context): Intent? {
        return loadClassOrNull<Activity>(SETTINGS_CLASS)
            ?.let { Intent(context, it) }
    }

}