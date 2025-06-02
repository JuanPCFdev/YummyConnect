package com.jpdev.yummyconnect.domain.usecase.comment

import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import javax.inject.Inject

class UpdateCommentUseCase @Inject constructor(
    private val commentRepository: CommentRepository
) {
    suspend operator fun invoke(comment: Comment) = commentRepository.updateComment(comment)
}