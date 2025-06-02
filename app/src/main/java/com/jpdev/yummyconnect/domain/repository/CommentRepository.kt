package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Comment

interface CommentRepository {
    //CRUD
    //Create
    suspend fun addComment(comment: Comment)
    //Read
    suspend fun getCommentsByPostId(postId: String): List<Comment>
    //Update
    suspend fun updateComment(comment: Comment)
    //Delete
    suspend fun deleteComment(commentId: String)
}