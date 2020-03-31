package dev.olog.detail

import android.content.Context
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import dev.olog.core.dagger.injectable.InjectableComponent

class DetailActivity : AppCompatActivity(R.layout.activity_detail),
    InjectableComponent {

    override fun onCreate(savedInstanceState: Bundle?) {
        // TODO dagger setup
        super.onCreate(savedInstanceState)
    }

    override val context: Context = this
}