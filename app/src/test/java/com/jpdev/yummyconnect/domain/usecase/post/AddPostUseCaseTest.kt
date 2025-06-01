package com.jpdev.yummyconnect.domain.usecase.post

import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import com.jpdev.yummyconnect.domain.usecase.AddPostUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class AddPostUseCaseTest {

    private val mockPostRepo: PostRepository = mock()
    private lateinit var addPostUseCase: AddPostUseCase

    @Before
    fun setUp() {
        addPostUseCase = AddPostUseCase(mockPostRepo)
    }

    @Test
    fun `invoke should call repository addPost with same post`() = runBlocking {
        val post = Post(
            id = "p1",
            userId = "u1",
            recipeId = "r1",
            image = "someUrl",
            timestamp = 123456L,
            likes = emptySet()
        )

        addPostUseCase(post)

        verify(mockPostRepo).addPost(post)
    }

}