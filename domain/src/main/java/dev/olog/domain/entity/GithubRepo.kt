package dev.olog.domain.entity

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize
import java.util.*

@Parcelize
data class GithubRepo(
    val fork: Boolean?,
    val hasDownloads: Boolean?,
    val hasIssues: Boolean?,
    val hasWiki: Boolean?,
    val isPrivate: Boolean,
    val createdAt: Date?,
    val pushedAt: Date?,
    val updatedAt: Date?,
    val forks: Int?,
    val id: Long?,
    val openIssues: Int?,
    val size: Int?,
    val watchers: Int?,
    val description: String?,
    val homepage: String?,
    val language: String?,
    val name: String?,
    val owner: GithubUser?
) : Parcelable
