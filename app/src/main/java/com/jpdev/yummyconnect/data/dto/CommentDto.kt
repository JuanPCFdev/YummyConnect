package com.jpdev.yummyconnect.data.dto

import com.jpdev.yummyconnect.domain.model.Comment

data class CommentDto(
    val id: String = "",
    val postId: String = "",
    val userId: String = "",
    val text: String = "",
    val timestamp: Long = 0L,
)

fun CommentDto.toDomain(): Comment = Comment(
    id = this.id,
    postId = this.postId,
    userId = this.userId,
    text = this.text,
    timestamp = this.timestamp
)

fun Comment.toDto(): CommentDto = CommentDto(
    id = this.id,
    postId = this.postId,
    userId = this.userId,
    text = this.text,
    timestamp = this.timestamp
)
