package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.repository.AuthRepository
import com.jpdev.yummyconnect.domain.usecase.SignOutUseCase
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

class SignOutUseCaseTest {
    private val mockAuthRepo: AuthRepository = mock()
    private lateinit var signOutUseCase: SignOutUseCase

    @Before
    fun setUp() {
        signOutUseCase = SignOutUseCase(mockAuthRepo)
    }

    @Test
    fun `invoke should call repository signOut`() = runBlocking{
        signOutUseCase()
        verify(mockAuthRepo).signOut()
    }
}