package com.jpdev.yummyconnect.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class PostDto(
    val id: String = "",
    val userId: String = "",
    val recipeId: String = "",
    val image: String = "",
    val timestamp: Long = 0L,
    val likes: List<String> = emptyList()
) : Parcelable