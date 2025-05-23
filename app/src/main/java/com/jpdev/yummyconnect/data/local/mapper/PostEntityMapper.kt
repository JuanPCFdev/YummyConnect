package com.jpdev.yummyconnect.data.local.mapper

import com.jpdev.yummyconnect.data.local.entity.CommentEntity
import com.jpdev.yummyconnect.data.local.entity.PostEntity
import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.model.Post

fun PostEntity.toDomain(likes: Set<String>) = Post(
    id = id,
    userId = userId,
    recipeId = recipeId,
    image = image,
    timestamp = timestamp,
    likes = likes
)
fun Post.toEntity() = PostEntity(this.id, this.userId, this.recipeId, this.image, this.timestamp)

fun CommentEntity.toDomain() = Comment(id, postId, userId, text, timestamp)
fun Comment.toEntity() = CommentEntity(id, postId, userId, text, timestamp)