package com.jpdev.yummyconnect.domain.usecase.post

import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import com.jpdev.yummyconnect.domain.usecase.GetPostsByUserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever


@OptIn(ExperimentalCoroutinesApi::class)
class GetPostsByUserUseCaseTest {
    private val mockPostRepo: PostRepository = mock()
    private lateinit var getPostsByUserUseCase: GetPostsByUserUseCase

    @Before
    fun setUp() {
        getPostsByUserUseCase = GetPostsByUserUseCase(mockPostRepo)
    }

    @Test
    fun `invoke should return list when repository returns posts`() = runBlocking {
        val p1 = Post(
            id = "pA", userId = "uA", recipeId = "rA",
            image = "", timestamp = 10L, likes = emptySet()
        )
        whenever(mockPostRepo.getPostsByUserId("uA")).thenReturn(listOf(p1))

        val result = getPostsByUserUseCase("uA")
        verify(mockPostRepo).getPostsByUserId("uA")
        assert(result.size == 1)
        assert(result[0].userId == "uA")
    }

}