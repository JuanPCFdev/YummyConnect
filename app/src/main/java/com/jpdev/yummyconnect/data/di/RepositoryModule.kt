package com.jpdev.yummyconnect.data.di

import com.jpdev.yummyconnect.data.repository.AuthRepositoryImpl
import com.jpdev.yummyconnect.data.repository.CommentRepositoryImpl
import com.jpdev.yummyconnect.data.repository.PostRepositoryImpl
import com.jpdev.yummyconnect.data.repository.RecipeRepositoryImpl
import com.jpdev.yummyconnect.data.repository.UserRepositoryImpl
import com.jpdev.yummyconnect.domain.repository.AuthRepository
import com.jpdev.yummyconnect.domain.repository.CommentRepository
import com.jpdev.yummyconnect.domain.repository.PostRepository
import com.jpdev.yummyconnect.domain.repository.RecipeRepository
import com.jpdev.yummyconnect.domain.repository.UserRepository
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
abstract class RepositoryModule {

    //Auth
    @Binds
    abstract fun bindAuthRepository(impl: AuthRepositoryImpl): AuthRepository

    //User
    @Binds
    abstract fun bindUserRepository(impl: UserRepositoryImpl): UserRepository

    //Recipe
    @Binds
    abstract fun bindRecipeRepository(impl: RecipeRepositoryImpl): RecipeRepository

    //Post
    @Binds
    abstract fun bindPostRepository(impl: PostRepositoryImpl): PostRepository

    //Comment
    @Binds
    abstract fun bindCommentRepository(impl: CommentRepositoryImpl): CommentRepository

}