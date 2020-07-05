package dev.olog.data

import dev.olog.domain.PokemonSprites
import dev.olog.domain.entity.Pokemon
import dev.olog.domain.entity.PokemonBrief
import me.sargunvohra.lib.pokekotlin.model.NamedApiResource
import me.sargunvohra.lib.pokekotlin.model.Pokemon as PokemonDto
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites as PokemonSpritesDto

internal fun NamedApiResource.toEntity(): PokemonBrief {
    return PokemonBrief(
        id = this.id,
        name = this.name
    )
}

internal fun PokemonDto.toEntity(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        order = this.order,
        weight = this.weight,
        sprites = this.sprites.toEntity()
    )
}

internal fun PokemonSpritesDto.toEntity(): PokemonSprites {
    return PokemonSprites(
        backDefault = this.backDefault,
        backShiny = this.backShiny,
        frontDefault = this.frontDefault,
        frontShiny = this.frontShiny,
        backFemale = this.backFemale,
        backShinyFemale = this.backShinyFemale,
        frontFemale = this.frontFemale,
        frontShinyFemale = this.frontShinyFemale
    )
}