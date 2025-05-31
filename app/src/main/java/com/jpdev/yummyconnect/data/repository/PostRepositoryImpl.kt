package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.dto.toDomain
import com.jpdev.yummyconnect.data.dto.toDto
import com.jpdev.yummyconnect.data.remote.firestore.FirestoreService
import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val firestoreService: FirestoreService
) : PostRepository{

    override suspend fun addPost(post: Post) {
        val dto = post.toDto()
        firestoreService.addPost(dto)
    }

    override suspend fun getAllPosts(): List<Post> {
        val dtos = firestoreService.getAllPosts()
        return dtos.map { it.toDomain() }
    }

    override suspend fun getPostsByUserId(userId: String): List<Post> {
        val dtos = firestoreService.getPostsByUserId(userId = userId)
        return dtos.map { it.toDomain() }
    }

    override suspend fun likePost(postId: String, userId: String) {
        firestoreService.likePost(postId = postId, userId = userId)
    }

}