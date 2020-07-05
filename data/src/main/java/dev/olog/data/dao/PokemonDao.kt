package dev.olog.data.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import dev.olog.data.entity.PokemonEntity

@Dao
internal abstract class PokemonDao {

    @Query("SELECT * FROM pokemon WHERE id = :id")
    abstract suspend fun getById(id: Int): PokemonEntity?

    @Insert
    abstract suspend fun insert(pokemon: PokemonEntity)

}