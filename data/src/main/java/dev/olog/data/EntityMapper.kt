package dev.olog.data

import dev.olog.data.entity.PokemonEntity
import dev.olog.data.entity.PokemonSpritesEntity
import dev.olog.data.entity.PokemonTypeEntity
import dev.olog.domain.entity.Pokemon
import dev.olog.domain.entity.PokemonSprites
import dev.olog.domain.entity.PokemonType

// region domain

internal fun PokemonEntity.toDomain(): Pokemon {
    return Pokemon(
        id = this.id,
        name = this.name,
        height = this.height,
        order = this.order,
        weight = this.weight,
        types = this.types.map { it.toDomain() },
        sprites = this.sprites.toDomain()
    )
}

internal fun PokemonTypeEntity.toDomain(): PokemonType {
    return PokemonType(
        slot = this.slot,
        type = this.type
    )
}

internal fun PokemonSpritesEntity.toDomain(): PokemonSprites {
    return PokemonSprites(
        backDefault = backDefault,
        backShiny = backShiny,
        frontDefault = frontDefault,
        frontShiny = frontShiny,
        backFemale = backFemale,
        backShinyFemale = backShinyFemale,
        frontFemale = frontFemale,
        frontShinyFemale = frontShinyFemale
    )
}

// endregion

// region entity

internal fun Pokemon.toEntity(): PokemonEntity {
    return PokemonEntity(
        id = this.id,
        name = this.name,
        height = this.height,
        order = this.order,
        weight = this.weight,
        types = this.types.map { it.toEntity() },
        sprites = this.sprites.toEntity()
    )
}

internal fun PokemonType.toEntity(): PokemonTypeEntity {
    return PokemonTypeEntity(
        slot = slot,
        type = type
    )
}

internal fun PokemonSprites.toEntity(): PokemonSpritesEntity {
    return PokemonSpritesEntity(
        backDefault = backDefault,
        backShiny = backShiny,
        frontDefault = frontDefault,
        frontShiny = frontShiny,
        backFemale = backFemale,
        backShinyFemale = backShinyFemale,
        frontFemale = frontFemale,
        frontShinyFemale = frontShinyFemale
    )
}

// endregion