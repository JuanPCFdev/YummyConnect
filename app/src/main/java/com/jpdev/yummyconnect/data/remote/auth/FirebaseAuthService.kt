package com.jpdev.yummyconnect.data.remote.auth

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.coroutines.tasks.await
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FirebaseAuthService @Inject constructor(
    private val firebaseAuth: FirebaseAuth
) {
    //Sign In
    suspend fun signIn(email: String, password: String) : FirebaseUser?{
        val result = firebaseAuth.signInWithEmailAndPassword(email, password).await()
        return result.user
    }

    //Sign Up
    suspend fun signUp(email: String, password: String) : FirebaseUser?{
        val result = firebaseAuth.createUserWithEmailAndPassword(email, password).await()
        return result.user
    }

    //Sign Out
    fun signOut(){
        firebaseAuth.signOut()
    }

    fun getCurrentUser(): FirebaseUser?{
        return firebaseAuth.currentUser
    }

}