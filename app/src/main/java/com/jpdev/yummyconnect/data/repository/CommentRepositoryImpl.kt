package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.data.remote.firestore.FirestoreService
import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import javax.inject.Inject

class CommentRepositoryImpl @Inject constructor(
    private val firestoreService: FirestoreService,
) : CommentRepository {
    //CRUD
    //Create
    override suspend fun addComment(comment: Comment) {
        val dto = comment.toDto()
        firestoreService.addComment(dto)
    }
    //Read all
    override suspend fun getCommentsByPostId(postId: String): List<Comment> {
        val dtos = firestoreService.getCommentsByPostId(postId = postId)
        return dtos.map { it.toDomain() }
    }
    //Update
    override suspend fun updateComment(comment: Comment) {
        val dto = comment.toDto()
        firestoreService.updateComment(dto)
    }
    //Delete
    override suspend fun deleteComment(commentId: String) {
        firestoreService.deleteComment(commentId = commentId)
    }
}