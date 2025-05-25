package com.jpdev.yummyconnect.data.remote.dto

data class CommentDTO(
    val id: String = "",
    val postId: String = "",
    val userId: String = "",
    val text: String = "",
    val timestamp: Long = 0
)