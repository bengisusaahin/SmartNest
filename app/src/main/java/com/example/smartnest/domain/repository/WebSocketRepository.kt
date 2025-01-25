package com.example.smartnest.domain.repository

import com.example.smartnest.domain.util.RootResult
import kotlinx.coroutines.flow.Flow

interface WebSocketRepository {
    fun connect(url: String)
    fun sendMessage(message: String)
    fun sendAuthRequest(username: String, password: String)
    fun observeMessages(): Flow<RootResult<String>>
    fun close()
}