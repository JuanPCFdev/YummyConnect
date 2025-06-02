package com.jpdev.yummyconnect.domain.usecase.post

import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class GetAllPostsUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke() = postRepository.getAllPosts()
}