package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.repository.CommentRepository
import javax.inject.Inject

class GetCommentsByPostUseCase @Inject constructor(
    private val repository: CommentRepository,
) {
    suspend operator fun invoke(postId: String) = repository.getCommentsByPostId(postId)
}