package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.repository.AuthRepository
import com.jpdev.yummyconnect.domain.usecase.auth.GetCurrentUserIdUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class GetCurrentUserIdUseCaseTest {
    private val mockAuthRepo: AuthRepository = mock()
    private lateinit var getCurrentUserIdUseCase: GetCurrentUserIdUseCase

    @Before
    fun setUp() {
        getCurrentUserIdUseCase = GetCurrentUserIdUseCase(mockAuthRepo)
    }

    @Test
    fun `invoke should return non-null UID when repository returns a String`() = runBlocking {
        whenever(mockAuthRepo.getCurrentUserId()).thenReturn("u123")

        val uid = getCurrentUserIdUseCase()

        assert(uid == "u123")
    }

    @Test
    fun `invoke should return null when repository returns null`() = runBlocking {
        whenever(mockAuthRepo.getCurrentUserId()).thenReturn(null)

        val uid = getCurrentUserIdUseCase()

        assert(uid == null)
    }
}