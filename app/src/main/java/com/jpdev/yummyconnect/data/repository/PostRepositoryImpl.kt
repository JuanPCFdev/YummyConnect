package com.jpdev.yummyconnect.data.repository

import com.jpdev.yummyconnect.data.local.dao.CommentDao
import com.jpdev.yummyconnect.data.local.dao.PostDao
import com.jpdev.yummyconnect.data.local.mapper.toDomain
import com.jpdev.yummyconnect.data.local.mapper.toEntity
import com.jpdev.yummyconnect.data.remote.firebase.FirestoreService
import com.jpdev.yummyconnect.data.remote.mapper.toDomain
import com.jpdev.yummyconnect.data.remote.mapper.toDto
import com.jpdev.yummyconnect.data.remote.mapper.toEntity
import com.jpdev.yummyconnect.domain.model.Comment
import com.jpdev.yummyconnect.domain.model.Post
import com.jpdev.yummyconnect.domain.repository.PostRepository
import javax.inject.Inject

class PostRepositoryImpl @Inject constructor(
    private val postDao: PostDao,
    private val commentDao: CommentDao,
    private val firestore: FirestoreService,
): PostRepository {
    override suspend fun getPosts(recipeId: String): List<Post> {
        val local = postDao.getPostsForRecipe(recipeId).map { it.toDomain(emptySet()) }
        if (local.isNotEmpty()) return local
        val remote = firestore.getPosts(recipeId).map { it.toDomain() }
        remote.forEach { postDao.insertPost(it.toEntity()) }
        return remote
    }

    override suspend fun createPost(imageData: ByteArray, post: Post) {
        val dto = post.copy().toDto()
        firestore.savePost(dto)
        postDao.insertPost(dto.toEntity())
    }

    override suspend fun getComments(postId: String): List<Comment> =
        commentDao.getCommentsForPost(postId).map { it.toDomain() }

    override suspend fun addComment(comment: Comment) {
        firestore.saveComment(comment.toDto())
        commentDao.insertComment(comment.toEntity())
    }
}