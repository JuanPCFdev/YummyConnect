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

    //Users CRUD
    //Create User -- Update User
    suspend fun createOrUpdateUser(userDto: UserDto) {
        usersCollection().document(userDto.id).set(userDto).await()
    }

    //Read User
    suspend fun getUserById(id: String): UserDto? {
        val snapshot = usersCollection().document(id).get().await()
        return snapshot.toObject(UserDto::class.java)
    }

    //Delete User
    suspend fun deleteUser(id: String) {
        // 1. Delete the user
        usersCollection().document(id).delete().await()

        // 2. delete user recipes
        recipesCollection().whereEqualTo("userId", id).get().await().documents.forEach {
            it.reference.delete().await()
        }

        // 3. get posts of the user
        val userPosts = postsCollection().whereEqualTo("userId", id).get().await().documents

        // 4. delete comments of those posts and then the posts
        userPosts.forEach { post ->
            // delete commentary of the post
            commentsCollection()
                .whereEqualTo("postId", post.id)
                .get().await().documents.forEach { comment ->
                    comment.reference.delete().await()
                }
            post.reference.delete().await() // Delete the post
        }

        // 5. Delete comments of the user
        commentsCollection()
            .whereEqualTo("userId", id)
            .get().await().documents.forEach {
                it.reference.delete().await()
            }
    }


    //Recipes CRUD
    //Create Recipe
    suspend fun addRecipe(recipeDto: RecipeDto) {
        val docRef = if (recipeDto.id.isBlank()) {
            recipesCollection().document()
        } else {
            recipesCollection().document(recipeDto.id)
        }
        val aux = recipeDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }
    //Read Recipes
    suspend fun getRecipesByUserId(userId: String): List<RecipeDto> {
        val snapshot = recipesCollection().whereEqualTo("userId", userId).get().await()
        return snapshot.toObjects(RecipeDto::class.java)
    }
    //Read Single Recipe
    suspend fun getRecipeById(id: String): RecipeDto? {
        val snapshot = recipesCollection().document(id).get().await()
        return snapshot.toObject(RecipeDto::class.java)
    }
    //Update Recipe
    suspend fun updateRecipe(recipeDto: RecipeDto) {
        recipesCollection().document(recipeDto.id).set(recipeDto).await()
    }
    //Delete Recipe
    suspend fun deleteRecipe(recipeId: String) {
        recipesCollection().document(recipeId).delete().await()
    }

    //Posts CRUD
    //Create
    suspend fun addPost(postDto: PostDto) {
        val docRef = if (postDto.id.isBlank()) {
            postsCollection().document()
        } else {
            postsCollection().document(postDto.id)
        }
        val aux = postDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }
    //Read all from all
    suspend fun getAllPosts(): List<PostDto> {
        val snapshot = postsCollection().orderBy("timestamp").get().await()
        return snapshot.toObjects(PostDto::class.java)
    }
    //Read all from one
    suspend fun getPostsByUserId(userId: String): List<PostDto> {
        val snapshot = postsCollection().whereEqualTo("userId", userId).get().await()
        return snapshot.toObjects(PostDto::class.java)
    }
    //Read one
    suspend fun getPostById(id: String): PostDto? {
        val snapshot = postsCollection().document(id).get().await()
        return snapshot.toObject(PostDto::class.java)
    }
    //Update
    suspend fun updatePost(postDto: PostDto) {
        postsCollection().document(postDto.id).set(postDto).await()
    }
    //Delete
    suspend fun deletePost(postId: String) {
        postsCollection().document(postId).delete().await()
    }
    //Like
    suspend fun likePost(postId: String, userId: String) {
        val postRef = postsCollection().document(postId)
        firestore.runTransaction { transaction ->
            val snapshot = transaction.get(postRef)
            val currentLikes = snapshot.get("likes") as? List<String> ?: emptyList()
            val updatedLikes = currentLikes.toMutableSet().apply { add(userId) }.toList()
            transaction.update(postRef, "likes", updatedLikes)
        }.await()
    }

    //Comments CRUD
    //Create
    suspend fun addComment(commentDto: CommentDto) {
        val docRef = if (commentDto.id.isBlank()) {
            commentsCollection().document()
        } else {
            commentsCollection().document(commentDto.id)
        }
        val aux = commentDto.copy(id = docRef.id)
        docRef.set(aux).await()
    }
    //Read all
    suspend fun getCommentsByPostId(postId: String): List<CommentDto> {
        val snapshot =
            commentsCollection().whereEqualTo("postId", postId).orderBy("timestamp").get().await()
        return snapshot.toObjects(CommentDto::class.java)
    }
    //Update
    suspend fun updateComment(commentDto: CommentDto) {
        commentsCollection().document(commentDto.id).set(commentDto).await()
    }
    //Delete
    suspend fun deleteComment(commentId: String) {
        commentsCollection().document(commentId).delete().await()
    }

}