package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Post

interface PostRepository {
    suspend fun addPost(post: Post)
    suspend fun getAllPosts(): List<Post>
    suspend fun getPostsByUserId(userId: String): List<Post>
    suspend fun likePost(postId: String, userId: String)
}