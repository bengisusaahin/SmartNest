package com.example.smartnest.domain.usecase

import com.example.smartnest.domain.repository.WebSocketRepository
import com.example.smartnest.domain.util.RootResult
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class ObserveWebSocketMessagesUseCase @Inject constructor(
    private val webSocketRepository: WebSocketRepository
) {
    operator fun invoke(): Flow<RootResult<String>> = webSocketRepository.observeMessages()
}
