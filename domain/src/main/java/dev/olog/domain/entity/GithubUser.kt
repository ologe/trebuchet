package dev.olog.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GithubUser(
    val id: Int?,
    val avatarUrl: String?,
    val email: String?,
    val name: String?
) : Parcelable