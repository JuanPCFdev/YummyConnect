package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class GetPostsByUserUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(userId: String) = postRepository.getPostsByUserId(userId)
}