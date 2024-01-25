package com.adrian.procastiless.core.data

import com.adrian.procastiless.data.userrepository.api.UserRepo
import com.adrian.procastiless.data.userrepository.impl.UserRepoImpl
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent

@Module
@InstallIn(SingletonComponent::class)
interface UserModule {
    @Binds
    fun bindsUserRepo(
        userRepoImpl: UserRepoImpl
    ): UserRepo
}