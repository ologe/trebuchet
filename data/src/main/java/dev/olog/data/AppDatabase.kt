package dev.olog.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverter
import androidx.room.TypeConverters
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dev.olog.data.dao.PokemonDao
import dev.olog.data.entity.PokemonEntity
import dev.olog.data.entity.PokemonSpritesEntity
import dev.olog.data.entity.PokemonTypeEntity

@Database(
    entities = [
        PokemonEntity::class
    ],
    exportSchema = true,
    version = 1
)
@TypeConverters(PokemonConverters::class)
internal abstract class AppDatabase : RoomDatabase() {

    abstract fun pokemonDao(): PokemonDao

}


internal object PokemonConverters {

    private val gson = Gson()

    @TypeConverter
    @JvmStatic
    internal fun serializeTypes(data: List<PokemonTypeEntity>): String {
        return gson.toJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun deserializeTypes(data: String): List<PokemonTypeEntity> {
        val token = object : TypeToken<List<PokemonTypeEntity>>() {}.type
        return gson.fromJson<List<PokemonTypeEntity>>(data, token)
    }

    @TypeConverter
    @JvmStatic
    fun serializeSprites(data: PokemonSpritesEntity): String {
        return gson.toJson(data)
    }

    @TypeConverter
    @JvmStatic
    fun deserializeSprites(data: String): PokemonSpritesEntity {
        val token = object : TypeToken<PokemonSpritesEntity>() {}.type
        return gson.fromJson<PokemonSpritesEntity>(data, token)
    }

}