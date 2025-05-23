package com.jpdev.yummyconnect.domain.model

data class Comment(
    val id: String = "",
    val postId: String,
    val userId: String,
    val text: String,
    val timestamp: Long = System.currentTimeMillis()
)