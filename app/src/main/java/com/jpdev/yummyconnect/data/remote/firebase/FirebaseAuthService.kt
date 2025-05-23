package com.jpdev.yummyconnect.data.remote.firebase

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

// Registro/login
class FirebaseAuthService @Inject constructor(
    private val auth: FirebaseAuth
) {
    suspend fun signIn(email: String, password: String) =
        auth.signInWithEmailAndPassword(email, password).await()

    suspend fun getCurrentUser(): FirebaseUser? = auth.currentUser
}