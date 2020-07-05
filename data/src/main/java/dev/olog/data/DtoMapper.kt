@file:SuppressLint("DefaultLocale")


package dev.olog.data

import android.annotation.SuppressLint
import dev.olog.domain.entity.Pokemon
import dev.olog.domain.entity.PokemonSprites
import dev.olog.domain.entity.PokemonType
import me.sargunvohra.lib.pokekotlin.model.Pokemon as PokemonDto
import me.sargunvohra.lib.pokekotlin.model.PokemonSprites as PokemonSpritesDto
import me.sargunvohra.lib.pokekotlin.model.PokemonType as PokemonTypeDto

internal fun PokemonDto.toDomain(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name.capitalize(),
        height = this.height,
        order = this.order,
        weight = this.weight,
        sprites = this.sprites.toDomain(),
        types = this.types.map { it.toDomain() }
    )
}

internal fun PokemonSpritesDto.toDomain(): PokemonSprites {
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

internal fun PokemonTypeDto.toDomain(): PokemonType {
    return PokemonType(
        slot = this.slot,
        type = this.type.name.capitalize()
    )
}