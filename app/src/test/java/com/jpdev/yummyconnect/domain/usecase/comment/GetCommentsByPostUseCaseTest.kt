package com.jpdev.yummyconnect.domain.usecase.comment

import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import com.jpdev.yummyconnect.domain.usecase.GetCommentsByPostUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class GetCommentsByPostUseCaseTest {
    private val mockCommentRepo: CommentRepository = mock()
    private lateinit var getCommentsByPostUseCase: GetCommentsByPostUseCase

    @Before
    fun setUp() {
        getCommentsByPostUseCase = GetCommentsByPostUseCase(mockCommentRepo)
    }

    @Test
    fun `invoke should return list of comments when repository returns list`() = runBlocking {
        val c1 = Comment(id = "cA", postId = "pA", userId = "uA", text = "X", timestamp = 1L)
        val c2 = Comment(id = "cB", postId = "pA", userId = "uB", text = "Y", timestamp = 2L)
        whenever(mockCommentRepo.getCommentsByPostId("pA")).thenReturn(listOf(c1, c2))

        val result = getCommentsByPostUseCase("pA")
        verify(mockCommentRepo).getCommentsByPostId("pA")
        assert(result.size == 2)
        assert(result[1].text == "Y")

    }
}