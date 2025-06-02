package com.jpdev.yummyconnect.domain.usecase.comment

import com.jpdev.yummyconnect.domain.repository.CommentRepository
import javax.inject.Inject

class DeleteCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend operator fun invoke(commentId: String) = commentRepository.deleteComment(commentId)
}