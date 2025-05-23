package com.jpdev.yummyconnect.data.remote.mapper

import com.jpdev.yummyconnect.data.local.entity.PostEntity
import com.jpdev.yummyconnect.data.remote.dto.PostDto
import com.jpdev.yummyconnect.domain.model.Post

fun PostDto.toDomain() = Post(
    id = id,
    userId = userId,
    recipeId = recipeId,
    image = image,
    timestamp = timestamp,
    likes = likes.toSet()
)
fun Post.toDto() = PostDto(id, userId, recipeId, image, timestamp, likes.toList())
fun PostDto.toEntity() = PostEntity(id = id, userId = userId, recipeId = recipeId, image = image, timestamp = timestamp)
fun PostEntity.toDto() = PostDto(id = id, userId = userId, recipeId = recipeId, image = image, timestamp = timestamp, likes = emptyList())