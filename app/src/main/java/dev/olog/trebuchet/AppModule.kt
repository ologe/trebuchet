package dev.olog.trebuchet

import android.content.Context
import dagger.Binds
import dagger.Module
import dev.olog.core.dagger.ApplicationContext

@Module
abstract class AppModule {

    @Binds
    @ApplicationContext
    internal abstract fun provideContext(instance: App): Context

}