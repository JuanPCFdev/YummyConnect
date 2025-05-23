package com.jpdev.yummyconnect.data.remote.mapper

import com.jpdev.yummyconnect.data.local.entity.CommentEntity
import com.jpdev.yummyconnect.data.remote.dto.CommentDto
import com.jpdev.yummyconnect.domain.model.Comment

fun CommentDto.toDomain() = Comment(id, postId, userId, text, timestamp)
fun Comment.toDto() = CommentDto(id, postId, userId, text, timestamp)
fun CommentDto.toEntity() = CommentEntity(id = id, postId = postId, userId = userId, text = text, timestamp = timestamp)
fun CommentEntity.toDto() = CommentDto(id = id, postId = postId, userId = userId, text = text, timestamp = timestamp)