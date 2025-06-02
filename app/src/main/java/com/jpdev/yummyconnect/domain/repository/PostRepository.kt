package com.jpdev.yummyconnect.domain.repository

import com.jpdev.yummyconnect.domain.model.Post

interface PostRepository {
    //CRUD
    //Create
    suspend fun addPost(post: Post)
    //Read all from all
    suspend fun getAllPosts(): List<Post>
    //Read all from one
    suspend fun getPostsByUserId(userId: String): List<Post>
    //Read one
    suspend fun getPostById(id: String): Post?
    //Update
    suspend fun updatePost(post: Post)
    //Delete
    suspend fun deletePost(postId: String)
    //Like
    suspend fun likePost(postId: String, userId: String)
}