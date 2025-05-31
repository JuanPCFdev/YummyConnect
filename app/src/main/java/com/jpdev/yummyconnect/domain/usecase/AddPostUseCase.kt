package com.jpdev.yummyconnect.domain.usecase

import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class AddPostUseCase @Inject constructor(
    private val postRepository: PostRepository,
) {
    suspend operator fun invoke(post: Post) {
        postRepository.addPost(post)
    }
}