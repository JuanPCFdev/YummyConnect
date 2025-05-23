package com.jpdev.yummyconnect.data.remote.dto

import android.os.Parcelable
import kotlinx.parcelize.Parcelize

@Parcelize
data class CommentDto(
    val id: String = "",
    val postId: String = "",
    val userId: String = "",
    val text: String = "",
    val timestamp: Long = 0L
) : Parcelable