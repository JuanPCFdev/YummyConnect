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
    override suspend fun addComment(comment: Comment) {
        val dto = comment.toDto()
        firestoreService.addComment(dto)
    }

    override suspend fun getCommentsByPostId(postId: String): List<Comment> {
        val dtos = firestoreService.getCommentsByPostId(postId = postId)
        return dtos.map { it.toDomain() }
    }
}