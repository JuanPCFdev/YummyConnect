package com.jpdev.yummyconnect.data.dto

import com.jpdev.yummyconnect.domain.model.Post

data class PostDto(
    val id: String = "",
    val userId: String = "",
    val recipeId: String = "",
    val image: String = "",
    val timestamp: Long = 0L,
    val likes: List<String> = emptyList(),
)

fun PostDto.toDomain(): Post = Post(
    id = this.id,
    userId = this.userId,
    recipeId = this.recipeId,
    image = this.image,
    timestamp = this.timestamp,
    likes = this.likes.toSet()
)

fun Post.toDto(): PostDto = PostDto(
    id = this.id,
    userId = this.userId,
    recipeId = this.recipeId,
    image = this.image,
    timestamp = this.timestamp,
    likes = this.likes.toList()
)