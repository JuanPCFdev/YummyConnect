package com.jpdev.yummyconnect.domain.usecase.post

import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import com.jpdev.yummyconnect.domain.usecase.post.GetAllPostsUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class GetAllPostsUseCaseTest {
    private val mockPostRepo: PostRepository = mock()
    private lateinit var getAllPostsUseCase: GetAllPostsUseCase

    @Before
    fun setUp() {
        getAllPostsUseCase = GetAllPostsUseCase(mockPostRepo)
    }

    @Test
    fun `invoke should return list of posts when repository returns list`() = runBlocking {
        val p1 = Post(
            id = "p1", userId = "u2", recipeId = "r2",
            image = "", timestamp = 1L, likes = emptySet()
        )
        val p2 = Post(
            id = "p2", userId = "u3", recipeId = "r3",
            image = "", timestamp = 2L, likes = setOf("u2")
        )
        whenever(mockPostRepo.getAllPosts()).thenReturn(listOf(p1, p2))

        val result = getAllPostsUseCase()
        verify(mockPostRepo).getAllPosts()
        assert(result.size == 2)
        assert(result[1].likes.contains("u2"))
    }
}