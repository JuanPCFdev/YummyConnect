package com.jpdev.yummyconnect.domain.model

data class Post(
    val id: String = "",
    val userId: String,
    val recipeId: String,
    val image: String,
    val timestamp: Long = System.currentTimeMillis(),
    val likes: Set<String> = emptySet() // IDs of users who gave likes
)