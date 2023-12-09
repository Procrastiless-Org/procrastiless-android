package com.adrian.procastiless.data.userrepository.impl

import com.adrian.procastiless.data.userrepository.api.UserRepo
import com.adrian.procastiless.data.userrepository.models.UserModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class UserRepoImpl @Inject constructor() : UserRepo {
    override val userData: Flow<UserModel>
        get() = flow {
            emit(
                UserModel(
                    name = "",
                    id = "",
                    avatarUrl = "",
                    email = "",
                    experience = 0
                )
            )
        }

    override suspend fun signingUser() {
        TODO("Not yet implemented")
    }

    override suspend fun signupUser() {
        TODO("Not yet implemented")
    }

    override suspend fun logoutUser() {
        TODO("Not yet implemented")
    }

    override suspend fun deleteAccount() {
        TODO("Not yet implemented")
    }
}