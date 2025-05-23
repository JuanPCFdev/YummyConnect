package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.model.Post

interface PostRepository {
    suspend fun getPosts(recipeId: String): List<Post>
    suspend fun createPost(imageData: ByteArray, post: Post)
    suspend fun getComments(postId: String): List<Comment>
    suspend fun addComment(comment: Comment)
}