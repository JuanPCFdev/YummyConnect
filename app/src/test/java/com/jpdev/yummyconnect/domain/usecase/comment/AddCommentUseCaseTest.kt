package com.jpdev.yummyconnect.domain.usecase.comment

import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import com.jpdev.yummyconnect.domain.usecase.comment.AddCommentUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class AddCommentUseCaseTest {
    private val mockCommentRepo: CommentRepository = mock()
    private lateinit var addCommentUseCase: AddCommentUseCase

    @Before
    fun setUp() {
        addCommentUseCase = AddCommentUseCase(mockCommentRepo)
    }

    @Test
    fun `invoke should call repository addComment with same comment`() = runBlocking {
        val comment = Comment(
            id = "c1", postId = "p1", userId = "u1", text = "Hola", timestamp = 123L
        )
        addCommentUseCase(comment)
        verify(mockCommentRepo).addComment(comment)
    }
}