package com.adrian.procastiless.data.userrepository.api

import com.adrian.procastiless.data.userrepository.models.UserModel
import kotlinx.coroutines.flow.Flow

interface UserRepo {
    val userData: Flow<UserModel>
    suspend fun signingUser()
    suspend fun signupUser()
    suspend fun logoutUser()
    suspend fun deleteAccount()
}