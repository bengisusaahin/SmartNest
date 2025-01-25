package com.example.smartnest.domain.usecase

import com.example.smartnest.domain.repository.WebSocketRepository
import javax.inject.Inject

class SendWebSocketMessageUseCase @Inject constructor(
    private val webSocketRepository: WebSocketRepository
) {
    operator fun invoke(message: String) = webSocketRepository.sendMessage(message)
}
