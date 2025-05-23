package com.jpdev.yummyconnect.data.remote.firebase

import com.google.firebase.firestore.FirebaseFirestore
import com.jpdev.yummyconnect.data.remote.dto.CommentDto
import com.jpdev.yummyconnect.data.remote.dto.PostDto
import com.jpdev.yummyconnect.data.remote.dto.RecipeDto
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// CRUD en Firestore
class FirestoreService @Inject constructor(
    private val firestore: FirebaseFirestore
) {
    private val recipesCol = firestore.collection("recipes")
    private val postsCol = firestore.collection("posts")
    private val commentsCol = firestore.collection("comments")

    suspend fun getRecipesForUser(userId: String): List<RecipeDto> =
        recipesCol.whereEqualTo("userId", userId)
            .get().await().toObjects(RecipeDto::class.java)

    suspend fun saveRecipe(dto: RecipeDto) =
        recipesCol.document(dto.id).set(dto).await()

    suspend fun getPosts(recipeId: String): List<PostDto> =
        postsCol.whereEqualTo("recipeId", recipeId)
            .get().await().toObjects(PostDto::class.java)

    suspend fun savePost(dto: PostDto) =
        postsCol.document(dto.id).set(dto).await()

    suspend fun getComments(postId: String): List<CommentDto> =
        commentsCol.whereEqualTo("postId", postId)
            .get().await().toObjects(CommentDto::class.java)

    suspend fun saveComment(dto: CommentDto) =
        commentsCol.document(dto.id).set(dto).await()
}