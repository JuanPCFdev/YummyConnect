package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Comment

interface CommentRepository {
    suspend fun addComment(comment: Comment)
    suspend fun getCommentsByPostId(postId: String): List<Comment>
}