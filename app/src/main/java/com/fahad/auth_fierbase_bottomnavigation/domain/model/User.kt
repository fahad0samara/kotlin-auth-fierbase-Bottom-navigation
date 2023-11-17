package com.fahad.auth_fierbase_bottomnavigation.domain.model


data class User(
    val uid: String,
    val email: String,
    val displayName: String?,
    val photoUrl: String?,
    val isEmailVerified: Boolean,




    )