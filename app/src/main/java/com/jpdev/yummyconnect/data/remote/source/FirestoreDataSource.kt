package com.jpdev.yummyconnect.data.remote.source

import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.FirebaseFirestoreException
import com.google.firebase.firestore.Query
import com.jpdev.yummyconnect.data.remote.dto.RecipeDTO
import com.jpdev.yummyconnect.data.remote.dto.UserDto
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class FirestoreDataSource @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO,
) {
    //Firestore Collections
    private val userCollection = firestore.collection("users")
    private val recipeCollection = firestore.collection("recipes")
    private val postCollection = firestore.collection("posts")

    //Create a new user in firestore
    suspend fun createUser(userId: String, name: String, email: String) =
        withContext(ioDispatcher) {
            val userDTO = UserDto(
                id = userId,
                name = name,
                email = email
            )
            userCollection.document(userId).set(userDTO).await()
        }

    //Get users by id
    suspend fun getUser(userId: String): Result<UserDto> = withContext(ioDispatcher) {
        try {
            val snapshot = userCollection.document(userId).get().await()
            if (snapshot.exists()) {
                Result.success(snapshot.toObject(UserDto::class.java)!!)
            } else {
                Result.failure(FirestoreError.UserNotFound)
            }
        } catch (e: Exception) {
            Result.failure(e.toFirestoreError())
        }
    }

    //GetRecipes from user
    suspend fun getRecipes(userId: String): Result<List<RecipeDTO>> = withContext(ioDispatcher) {
        try {
            val querySnapshot = recipeCollection
                .whereEqualTo("userId", userId)
                .orderBy("createdAt", Query.Direction.DESCENDING)
                .get()
                .await()

            val recipe = querySnapshot.documents.mapNotNull { documentSnapshot -> documentSnapshot.toObject(RecipeDTO::class.java) }
            Result.success(recipe)
        }catch (e: Exception) {
            Result.failure(e.toFirestoreError())
        }
    }

    //Mapping of errors of firestore
    private fun Exception.toFirestoreError(): FirestoreError {
        return when (this) {
            is FirebaseFirestoreException -> {
                when (code) {
                    FirebaseFirestoreException.Code.NOT_FOUND -> FirestoreError.DocumentNotFound
                    else -> FirestoreError.UnknownError
                }
            }
            else -> FirestoreError.UnknownError
        }
    }

}

//Specific errors of Firestore
sealed class FirestoreError :Exception(){
    object UserNotFound : FirestoreError()
    object DocumentNotFound : FirestoreError()
    object UnknownError : FirestoreError()
}