package dev.olog.domain.entity

import dev.olog.domain.PokemonSprites

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
//    val types: List<PokemonType>,
    val sprites: PokemonSprites
)