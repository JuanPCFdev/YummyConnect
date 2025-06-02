package com.jpdev.yummyconnect.domain.usecase.user

import com.jpdev.yummyconnect.domain.model.User
import com.jpdev.yummyconnect.domain.repository.UserRepository
import com.jpdev.yummyconnect.domain.usecase.user.CreateOrUpdateUserUseCase
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Test
import org.mockito.kotlin.mock
import org.mockito.kotlin.verify

@OptIn(ExperimentalCoroutinesApi::class)
class CreateOrUpdateUserUseCaseTest {
    private val mockUserRepo: UserRepository = mock()
    private lateinit var createOrUpdateUserUseCase: CreateOrUpdateUserUseCase

    @Before
    fun setUp() {
        createOrUpdateUserUseCase = CreateOrUpdateUserUseCase(mockUserRepo)
    }

    @Test
    fun `invoke should call repository createOrUpdateUser`() = runBlocking {
        val user = User(id = "u5", name = "Luis", email = "l@l.com", recipes = emptyList())

        createOrUpdateUserUseCase(user)

        verify(mockUserRepo).createOrUpdateUser(user)
    }

}