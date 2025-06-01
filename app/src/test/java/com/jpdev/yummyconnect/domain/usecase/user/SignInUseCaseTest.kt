package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.AuthRepository
import com.jpdev.yummyconnect.domain.usecase.SignInUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify
import org.mockito.kotlin.whenever

@OptIn(ExperimentalCoroutinesApi::class)
class SignInUseCaseTest {

    private val mockAuthRepo: AuthRepository = mock()
    private lateinit var signInUseCase: SignInUseCase

    @Before
    fun setUp() {
        signInUseCase = SignInUseCase(mockAuthRepo)
    }

    @Test
    fun `invoke should return User when repository returns User`() = runBlocking {
        val dummyUser = User(id = "u1", name = "Jhon Doe", email = "j@j.com", recipes = emptyList())
        whenever(mockAuthRepo.signIn("j@j.com", "pass")).thenReturn(dummyUser)

        val result = signInUseCase("j@j.com", "pass")

        verify(mockAuthRepo).signIn("j@j.com", "pass")
        assert(dummyUser == result)
    }

    @Test
    fun `invoke should return null when repository returns null`() = runBlocking {
        whenever(mockAuthRepo.signIn("j@j.com", "pass")).thenReturn(null)

        val result = signInUseCase("j@j.com", "pass")

        verify(mockAuthRepo).signIn("j@j.com", "pass")
        assert(result == null)
    }

}