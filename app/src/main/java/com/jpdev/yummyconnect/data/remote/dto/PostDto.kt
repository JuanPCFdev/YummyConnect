package com.jpdev.yummyconnect.data.remote.dto

data class PostDTO(
    val id: String = "",
    val userId: String = "",
    val recipeId: String = "",
    val image: String = "",
    val timestamp: Long = 0,
    val likes: Map<String, Boolean> = emptyMap()
)