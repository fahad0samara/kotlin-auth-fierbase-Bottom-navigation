package com.fahad.auth_fierbase_bottomnavigation.domain.repository

import com.fahad.auth_fierbase_bottomnavigation.domain.model.Response
import com.fahad.auth_fierbase_bottomnavigation.domain.model.User
import kotlinx.coroutines.flow.Flow

interface AuthRepository {
    suspend fun registerUser(
        email: String, password: String,
        displayName: String,
        photoUri: String
    ): Flow<Response<User>>

    suspend fun loginUser(email: String, password: String): Flow<Response<User>>


    suspend fun updateUserProfile(
        uid: String,
        displayName: String,
        photoUri: String
    ): Response<User>

    suspend fun logout(): Response<Unit>
    suspend fun sendEmailVerification(): Response<Unit>
    suspend fun markEmailAsVerified(): Response<Unit>
    suspend fun getUserData(): Response<User>
}
