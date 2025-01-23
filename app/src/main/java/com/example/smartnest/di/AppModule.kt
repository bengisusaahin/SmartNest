package com.example.smartnest.di

import com.example.smartnest.data.repository.WebSocketRepositoryImpl
import com.example.smartnest.data.service.WebSocketService
import com.example.smartnest.domain.repository.WebSocketRepository
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {
    @Provides
    @Singleton
    fun provideWebSocketService(): WebSocketService {
        return WebSocketService()
    }

    @Provides
    @Singleton
    fun provideWebSocketRepository(webSocketService: WebSocketService): WebSocketRepository {
        return WebSocketRepositoryImpl(webSocketService)
    }
}