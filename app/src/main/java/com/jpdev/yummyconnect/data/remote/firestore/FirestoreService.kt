package com.jpdev.yummyconnect.data.remote.firestore

import com.google.firebase.firestore.FirebaseFirestore
import com.jpdev.yummyconnect.data.dto.CommentDto
import com.jpdev.yummyconnect.data.dto.PostDto
import com.jpdev.yummyconnect.data.dto.RecipeDto
import com.jpdev.yummyconnect.data.dto.UserDto
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirestoreService @Inject constructor(
    private val firestore: FirebaseFirestore,
) {
    private fun usersCollection() = firestore.collection("users")

    private fun recipesCollection() = firestore.collection("recipes")

    private fun postsCollection() = firestore.collection("posts")

    private fun commentsCollection() = firestore.collection("comments")

    //Users

    suspend fun createOrUpdateUser(userDto: UserDto) {
        usersCollection().document(userDto.id).set(userDto).await()
    }

    suspend fun getUserById(id: String): UserDto? {
        val snapshot = usersCollection().document(id).get().await()
        return snapshot.toObject(UserDto::class.java)
    }

    //Recipes
    suspend fun addRecipe(recipeDto: RecipeDto) {
        val docRef = if (recipeDto.id.isBlank()) {
            recipesCollection().document()
        } else {
            recipesCollection().document(recipeDto.id)
        }
        val aux = recipeDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }

    suspend fun getRecipesByUserId(userId: String): List<RecipeDto> {
        val snapshot = recipesCollection().whereEqualTo("userId", userId).get().await()
        return snapshot.toObjects(RecipeDto::class.java)
    }

    suspend fun deleteRecipe(recipeId: String) {
        recipesCollection().document(recipeId).delete().await()
    }

    //Posts
    suspend fun addPost(postDto: PostDto) {
        val docRef = if (postDto.id.isBlank()) {
            postsCollection().document()
        } else {
            postsCollection().document(postDto.id)
        }
        val aux = postDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }

    suspend fun getAllPosts(): List<PostDto> {
        val snapshot = postsCollection().orderBy("timestamp").get().await()
        return snapshot.toObjects(PostDto::class.java)
    }

    suspend fun getPostsByUserId(userId: String): List<PostDto> {
        val snapshot = postsCollection().whereEqualTo("userId", userId).get().await()
        return snapshot.toObjects(PostDto::class.java)
    }

    suspend fun likePost(postId: String, userId: String) {
        val postRef = postsCollection().document(postId)
        firestore.runTransaction { transaction ->
            val snapshot = transaction.get(postRef)
            val currentLikes = snapshot.get("likes") as? List<String> ?: emptyList()
            val updatedLikes = currentLikes.toMutableSet().apply { add(userId) }.toList()
            transaction.update(postRef, "likes", updatedLikes)
        }.await()
    }

    //Comments
    suspend fun addComment(commentDto: CommentDto) {
        val docRef = if (commentDto.id.isBlank()) {
            commentsCollection().document()
        } else {
            commentsCollection().document(commentDto.id)
        }
        val aux = commentDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }

    suspend fun getCommentsByPostId(postId: String): List<CommentDto> {
        val snapshot =
            commentsCollection().whereEqualTo("postId", postId).orderBy("timestamp").get().await()
        return snapshot.toObjects(CommentDto::class.java)
    }

}