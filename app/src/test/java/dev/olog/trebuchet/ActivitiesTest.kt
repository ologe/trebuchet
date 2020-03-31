package dev.olog.trebuchet

import dev.olog.detail.DetailActivity
import dev.olog.intents.Activities
import dev.olog.settings.SettingsActivity
import org.junit.Assert.assertEquals
import org.junit.Test

class ActivitiesTest {

    @Test
    fun `test detail`() {
        assertEquals(DetailActivity::class.java.name, Activities.DETAIL_CLASS)
    }

    @Test
    fun `test settings`() {
        assertEquals(SettingsActivity::class.java.name, Activities.SETTINGS_CLASS)
    }

}
