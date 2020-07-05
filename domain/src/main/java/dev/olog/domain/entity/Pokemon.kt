package dev.olog.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class Pokemon(
    val id: Int,
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
    val types: List<PokemonType>,
    val sprites: PokemonSprites
) : Parcelable {

    val type1: PokemonType
        get() = types.first { it.slot == 1 }

    val type2: PokemonType?
        get() = types.find { it.slot == 2 }

    val colorHex: String
        get() {
            return when (type1.type.toLowerCase()) {
                "normal" -> "#A8A878"
                "grass" -> "#3acaa6"
                "ground" -> "#E0C067"
                "fighting" -> "#C03028"
                "rock" -> "#B89F38"
                "steel" -> "#B7B8D0"
                "fire" -> "#fd6065"
                "electric" -> "#ffd269"
                "flying" -> "#A890F0"
                "psychic" -> "#F85888"
                "bug" -> "#A8B821"
                "dragon" -> "#7038F8"
                "water" -> "#6cb6fb"
                "ice" -> "#98D8D8"
                "poison" -> "#9F40A0"
                "dark" -> "#705848"
                "ghost" -> "#705898"
                "fairy" -> "#FEAEC9"
                else -> "#000000"
            }
        }

    val number: String
        get() = "#${order.toString().padStart(3, '0')}"

}