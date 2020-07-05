package dev.olog.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonType(
    val slot: Int,
    val type: String
) : Parcelable