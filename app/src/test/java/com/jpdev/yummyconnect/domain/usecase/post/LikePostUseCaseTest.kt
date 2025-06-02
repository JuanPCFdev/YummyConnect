package com.jpdev.yummyconnect.domain.usecase.post

import com.jpdev.yummyconnect.domain.repository.PostRepository
import com.jpdev.yummyconnect.domain.usecase.post.LikePostUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class LikePostUseCaseTest {
    private val mockPostRepo: PostRepository = mock()
    private lateinit var likePostUseCase: LikePostUseCase

    @Before
    fun setUp() {
        likePostUseCase = LikePostUseCase(mockPostRepo)
    }

    @Test
    fun `invoke should call repository likePost with correct parameters`() = runBlocking {
        likePostUseCase("post123", "user888")
        verify(mockPostRepo).likePost("post123", "user888")
    }
}