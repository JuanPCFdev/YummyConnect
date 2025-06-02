package com.jpdev.yummyconnect.domain.di

import com.jpdev.yummyconnect.domain.usecase.comment.AddCommentUseCase
import com.jpdev.yummyconnect.domain.usecase.post.AddPostUseCase
import com.jpdev.yummyconnect.domain.usecase.recipe.AddRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.user.CreateOrUpdateUserUseCase
import com.jpdev.yummyconnect.domain.usecase.recipe.DeleteRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.post.GetAllPostsUseCase
import com.jpdev.yummyconnect.domain.usecase.comment.GetCommentsByPostUseCase
import com.jpdev.yummyconnect.domain.usecase.auth.GetCurrentUserIdUseCase
import com.jpdev.yummyconnect.domain.usecase.post.GetPostsByUserUseCase
import com.jpdev.yummyconnect.domain.usecase.recipe.GetRecipesByUserUseCase
import com.jpdev.yummyconnect.domain.usecase.user.GetUserByIdUseCase
import com.jpdev.yummyconnect.domain.usecase.post.LikePostUseCase
import com.jpdev.yummyconnect.domain.usecase.auth.SignInUseCase
import com.jpdev.yummyconnect.domain.usecase.auth.SignOutUseCase
import com.jpdev.yummyconnect.domain.usecase.auth.SignUpUseCase
import com.jpdev.yummyconnect.domain.usecase.comment.DeleteCommentUseCase
import com.jpdev.yummyconnect.domain.usecase.comment.UpdateCommentUseCase
import com.jpdev.yummyconnect.domain.usecase.post.DeletePostUseCase
import com.jpdev.yummyconnect.domain.usecase.post.GetSinglePostUseCase
import com.jpdev.yummyconnect.domain.usecase.post.UpdatePostUseCase
import com.jpdev.yummyconnect.domain.usecase.recipe.GetSingleRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.recipe.UpdateRecipeUseCase
import com.jpdev.yummyconnect.domain.usecase.user.DeleteUserUseCase
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object UseCaseModule {

    /** Auth **/
    //Sign In
    @Provides
    @Singleton
    fun provideSignInUseCase(signInUseCase: SignInUseCase): SignInUseCase = signInUseCase

    //sIgn Up
    @Provides
    @Singleton
    fun provideSignUpUseCase(signUpUseCase: SignUpUseCase): SignUpUseCase = signUpUseCase

    //Sign Out
    @Provides
    @Singleton
    fun provideSignOutUseCase(signOutUseCase: SignOutUseCase): SignOutUseCase = signOutUseCase

    //Get Current User
    @Provides
    @Singleton
    fun provideGetCurrentUserIdUseCase(getCurrentUserIdUseCase: GetCurrentUserIdUseCase): GetCurrentUserIdUseCase =
        getCurrentUserIdUseCase

    /** User **/
    //Create or Update
    @Provides
    @Singleton
    fun provideCreateOrUpdateUserUseCase(
        createOrUpdateUserUseCase: CreateOrUpdateUserUseCase,
    ): CreateOrUpdateUserUseCase = createOrUpdateUserUseCase

    //Get
    @Provides
    @Singleton
    fun provideGetUserByIdUseCase(
        getUserByIdUseCase: GetUserByIdUseCase,
    ): GetUserByIdUseCase = getUserByIdUseCase

    //Delete
    @Provides
    @Singleton
    fun provideDeleteUserUseCase(
        deleteUserUseCase: DeleteUserUseCase,
    ): DeleteUserUseCase = deleteUserUseCase

    /** Recipe **/
    //Create
    @Provides
    @Singleton
    fun provideAddRecipeUseCase(
        addRecipeUseCase: AddRecipeUseCase,
    ): AddRecipeUseCase = addRecipeUseCase

    //Get all
    @Provides
    @Singleton
    fun provideGetRecipesByUserUseCase(
        getRecipesByUserUseCase: GetRecipesByUserUseCase,
    ): GetRecipesByUserUseCase = getRecipesByUserUseCase

    //Get single
    @Provides
    @Singleton
    fun provideGetSingleRecipeUseCase(
        getSingleRecipeUseCase: GetSingleRecipeUseCase,
    ): GetSingleRecipeUseCase = getSingleRecipeUseCase

    //Update
    @Provides
    @Singleton
    fun provideUpdateRecipeUseCase(
        updateRecipeUseCase: UpdateRecipeUseCase,
    ): UpdateRecipeUseCase = updateRecipeUseCase

    //Delete
    @Provides
    @Singleton
    fun provideDeleteRecipeUseCase(
        deleteRecipeUseCase: DeleteRecipeUseCase,
    ): DeleteRecipeUseCase = deleteRecipeUseCase

    /** Post **/
    //Create
    @Provides
    @Singleton
    fun provideAddPostUseCase(
        addPostUseCase: AddPostUseCase,
    ): AddPostUseCase = addPostUseCase

    //Get all
    @Provides
    @Singleton
    fun provideGetAllPostsUseCase(
        getAllPostsUseCase: GetAllPostsUseCase,
    ): GetAllPostsUseCase = getAllPostsUseCase

    //Get by user
    @Provides
    @Singleton
    fun provideGetPostsByUserUseCase(
        getPostsByUserUseCase: GetPostsByUserUseCase,
    ): GetPostsByUserUseCase = getPostsByUserUseCase

    //Get Single
    @Provides
    @Singleton
    fun provideGetSinglePostUseCase(
        getSinglePostUseCase: GetSinglePostUseCase,
    ): GetSinglePostUseCase = getSinglePostUseCase

    //Update
    @Provides
    @Singleton
    fun provideUpdatePostUseCase(
        updatePostUseCase: UpdatePostUseCase,
    ): UpdatePostUseCase = updatePostUseCase

    //Delete
    @Provides
    @Singleton
    fun provideDeletePostUseCase(
        deletePostUseCase: DeletePostUseCase,
    ): DeletePostUseCase = deletePostUseCase

    //Like
    @Provides
    @Singleton
    fun provideLikePostUseCase(
        likePostUseCase: LikePostUseCase,
    ): LikePostUseCase = likePostUseCase

    /** Comment **/
    //Create
    @Provides
    @Singleton
    fun provideAddCommentUseCase(
        addCommentUseCase: AddCommentUseCase,
    ): AddCommentUseCase = addCommentUseCase

    //Get all
    @Provides
    @Singleton
    fun provideGetCommentsByPostUseCase(
        getCommentsByPostUseCase: GetCommentsByPostUseCase,
    ): GetCommentsByPostUseCase = getCommentsByPostUseCase

    //Update
    @Provides
    @Singleton
    fun provideUpdateCommentUseCase(
        updateCommentUseCase: UpdateCommentUseCase,
    ): UpdateCommentUseCase = updateCommentUseCase

    //Delete
    @Provides
    @Singleton
    fun provideDeleteCommentUseCase(
        deleteCommentUseCase: DeleteCommentUseCase,
    ): DeleteCommentUseCase = deleteCommentUseCase
}