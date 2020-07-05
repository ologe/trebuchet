package dev.olog.data

import android.content.Context
import androidx.room.Room
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.ApplicationComponent
import dagger.hilt.android.qualifiers.ApplicationContext
import dev.olog.data.dao.PokemonDao
import dev.olog.data.repository.PokedexRepository
import dev.olog.domain.gateway.PokedexGateway
import javax.inject.Singleton

@Module
@InstallIn(ApplicationComponent::class)
abstract class DataModule {

    @Binds
    @Singleton
    internal abstract fun bindPokedexRepo(impl: PokedexRepository): PokedexGateway

    companion object {

        @Provides
        @Singleton
        internal fun provideDatabase(
            @ApplicationContext context: Context
        ): AppDatabase {
            return Room.databaseBuilder(context, AppDatabase::class.java, "db")
                .build()
        }

        @Provides
        internal fun providePokemonDao(database: AppDatabase): PokemonDao {
            return database.pokemonDao()
        }

    }

}