package dev.olog.data.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "pokemon")
internal class PokemonEntity(
    @PrimaryKey(autoGenerate = false) val id: Int,
    val name: String,
    val height: Int,
    val order: Int,
    val weight: Int,
//    val species: NamedApiResource,
//    val abilities: List<PokemonAbility>,
//    val forms: List<NamedApiResource>,
//    val gameIndices: List<VersionGameIndex>,
//    val heldItems: List<PokemonHeldItem>,
//    val moves: List<PokemonMove>,
//    val stats: List<PokemonStat>,
    val types: List<PokemonTypeEntity>,
    val sprites: PokemonSpritesEntity
)

internal data class PokemonTypeEntity(
    val slot: Int,
    val type: String
)

internal data class PokemonSpritesEntity(
    val backDefault: String?,
    val backShiny: String?,
    val frontDefault: String?,
    val frontShiny: String?,
    val backFemale: String?,
    val backShinyFemale: String?,
    val frontFemale: String?,
    val frontShinyFemale: String?
)