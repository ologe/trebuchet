package dev.olog.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class PokemonBrief(
    val id: Int,
    val name: String
) : Parcelable