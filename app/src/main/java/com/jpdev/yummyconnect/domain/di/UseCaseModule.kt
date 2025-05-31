package com.jpdev.yummyconnect.domain.di

import com.jpdev.yummyconnect.domain.usecase.AddCommentUseCase
import com.jpdev.yummyconnect.domain.usecase.AddPostUseCase
import com.jpdev.yummyconnect.domain.usecase.AddRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.CreateOrUpdateUserUseCase
import com.jpdev.yummyconnect.domain.usecase.DeleteRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.GetAllPostsUseCase
import com.jpdev.yummyconnect.domain.usecase.GetCommentsByPostUseCase
import com.jpdev.yummyconnect.domain.usecase.GetCurrentUserIdUseCase
import com.jpdev.yummyconnect.domain.usecase.GetPostsByUserUseCase
import com.jpdev.yummyconnect.domain.usecase.GetRecipesByUserUseCase
import com.jpdev.yummyconnect.domain.usecase.GetUserByIdUseCase
import com.jpdev.yummyconnect.domain.usecase.LikePostUseCase
import com.jpdev.yummyconnect.domain.usecase.SignInUseCase
import com.jpdev.yummyconnect.domain.usecase.SignOutUseCase
import com.jpdev.yummyconnect.domain.usecase.SignUpUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    // Auth
    @Provides
    @Singleton
    fun provideSignInUseCase(signInUseCase: SignInUseCase): SignInUseCase = signInUseCase

    @Provides
    @Singleton
    fun provideSignUpUseCase(signUpUseCase: SignUpUseCase): SignUpUseCase = signUpUseCase

    @Provides
    @Singleton
    fun provideSignOutUseCase(signOutUseCase: SignOutUseCase): SignOutUseCase = signOutUseCase

    @Provides
    @Singleton
    fun provideGetCurrentUserIdUseCase(getCurrentUserIdUseCase: GetCurrentUserIdUseCase): GetCurrentUserIdUseCase = getCurrentUserIdUseCase

    /** User **/
    @Provides
    @Singleton
    fun provideCreateOrUpdateUserUseCase(
        createOrUpdateUserUseCase: CreateOrUpdateUserUseCase
    ): CreateOrUpdateUserUseCase = createOrUpdateUserUseCase

    @Provides
    @Singleton
    fun provideGetUserByIdUseCase(
        getUserByIdUseCase: GetUserByIdUseCase
    ): GetUserByIdUseCase = getUserByIdUseCase

    /** Recipe **/
    @Provides
    @Singleton
    fun provideAddRecipeUseCase(
        addRecipeUseCase: AddRecipeUseCase
    ): AddRecipeUseCase = addRecipeUseCase

    @Provides
    @Singleton
    fun provideGetRecipesByUserUseCase(
        getRecipesByUserUseCase: GetRecipesByUserUseCase
    ): GetRecipesByUserUseCase = getRecipesByUserUseCase

    @Provides
    @Singleton
    fun provideDeleteRecipeUseCase(
        deleteRecipeUseCase: DeleteRecipeUseCase
    ): DeleteRecipeUseCase = deleteRecipeUseCase

    /** Post **/
    @Provides
    @Singleton
    fun provideAddPostUseCase(
        addPostUseCase: AddPostUseCase
    ): AddPostUseCase = addPostUseCase

    @Provides
    @Singleton
    fun provideGetAllPostsUseCase(
        getAllPostsUseCase: GetAllPostsUseCase
    ): GetAllPostsUseCase = getAllPostsUseCase

    @Provides
    @Singleton
    fun provideGetPostsByUserUseCase(
        getPostsByUserUseCase: GetPostsByUserUseCase
    ): GetPostsByUserUseCase = getPostsByUserUseCase

    @Provides
    @Singleton
    fun provideLikePostUseCase(
        likePostUseCase: LikePostUseCase
    ): LikePostUseCase = likePostUseCase

    /** Comment **/
    @Provides
    @Singleton
    fun provideAddCommentUseCase(
        addCommentUseCase: AddCommentUseCase
    ): AddCommentUseCase = addCommentUseCase

    @Provides
    @Singleton
    fun provideGetCommentsByPostUseCase(
        getCommentsByPostUseCase: GetCommentsByPostUseCase
    ): GetCommentsByPostUseCase = getCommentsByPostUseCase

}