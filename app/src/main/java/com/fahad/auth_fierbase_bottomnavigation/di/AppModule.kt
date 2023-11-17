package com.fahad.auth_fierbase_bottomnavigation.di

import com.fahad.auth_fierbase_bottomnavigation.data.AuthRepositoryImpl
import com.fahad.auth_fierbase_bottomnavigation.domain.repository.AuthRepository
import com.fahad.auth_fierbase_bottomnavigation.ui.UserDataViewModel
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    fun provideAuthRepository(): AuthRepository {
        return AuthRepositoryImpl()
    }


    @Provides
    @Singleton
    fun provideUserDataViewModel(): UserDataViewModel {
        return UserDataViewModel(
            authRepository = AuthRepositoryImpl()
        )
    }
}