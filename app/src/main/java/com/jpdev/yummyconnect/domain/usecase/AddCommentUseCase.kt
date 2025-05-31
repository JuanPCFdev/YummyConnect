package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import javax.inject.Inject

class AddCommentUseCase @Inject constructor(
    private val repository: CommentRepository,
) {
    suspend operator fun invoke(comment: Comment) {
        repository.addComment(comment)
    }
}