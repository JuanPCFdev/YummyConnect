package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class LikePostUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(postId: String, userId: String) {
        postRepository.likePost(postId = postId, userId = userId)
    }
}