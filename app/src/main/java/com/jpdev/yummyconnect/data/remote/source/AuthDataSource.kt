package com.jpdev.yummyconnect.data.remote.source

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException
import com.google.firebase.auth.FirebaseAuthUserCollisionException
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.tasks.await
import kotlinx.coroutines.withContext
import javax.inject.Inject

class AuthDataSource @Inject constructor(
    private val auth: FirebaseAuth,
    private val firestoreDataSource: FirestoreDataSource,
    private val ioDispatcher: CoroutineDispatcher = Dispatchers.IO
) {
    //Email and password register
    suspend fun signUp(email: String, password: String, name: String): Result<Unit> = withContext(ioDispatcher) {
        try {
            val result = auth.createUserWithEmailAndPassword(email, password).await()
            val user = result.user ?: throw Exception("User not created")
            // Guardar datos adicionales en Firestore (ej: nombre)
            firestoreDataSource.createUser(user.uid, name, email)
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    //Sign In
    suspend fun signIn(email: String, password: String): Result<Unit> = withContext(ioDispatcher) {
        try {
            auth.signInWithEmailAndPassword(email, password).await()
            Result.success(Unit)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    //Actual User
    fun getCurrentUser(): FirebaseUser? = auth.currentUser

    //Close Session
    suspend fun signOut() = withContext(ioDispatcher) {
        auth.signOut()
    }

    //Auth Errors mapping
    private fun Exception.toAuthError(): AuthError {
        return when (this) {
            is FirebaseAuthInvalidCredentialsException -> AuthError.InvalidCredentials
            is FirebaseAuthUserCollisionException -> AuthError.EmailInUse
            else -> AuthError.UnknownError
        }
    }

}

//Specific errors of Auth
sealed class AuthError: Exception(){
    object InvalidCredentials: AuthError()
    object EmailInUse: AuthError()
    object UnknownError: AuthError()
}