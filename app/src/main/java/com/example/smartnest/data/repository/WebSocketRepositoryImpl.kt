package com.example.smartnest.data.repository

import com.example.smartnest.data.service.WebSocketService
import com.example.smartnest.domain.repository.WebSocketRepository
import com.example.smartnest.domain.util.RootResult
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject

class WebSocketRepositoryImpl @Inject constructor(
    private val webSocketService: WebSocketService
) : WebSocketRepository {

    override fun connect(url: String) {
        webSocketService.connect(url)
    }

    override fun sendMessage(message: String) {
        webSocketService.sendMessage(message)
    }

    override fun observeMessages(): Flow<RootResult<String>> = flow {
        emit(RootResult.Loading)
        try {
            webSocketService.messages.collect { message ->
                emit(RootResult.Success(message))
            }
        } catch (e: Exception) {
            emit(RootResult.Error(e.message ?: "Unknown error"))
        }
    }.flowOn(Dispatchers.IO)


    override fun close() {
        webSocketService.close()
    }

    override fun sendAuthRequest(username: String, password: String) {
        webSocketService.sendAuthRequest(username, password)
    }
}