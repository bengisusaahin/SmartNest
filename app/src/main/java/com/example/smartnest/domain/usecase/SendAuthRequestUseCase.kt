package com.example.smartnest.domain.usecase

import com.example.smartnest.domain.repository.WebSocketRepository
import javax.inject.Inject

class SendAuthRequestUseCase @Inject constructor(
    private val repository: WebSocketRepository
) {
    operator fun invoke(username: String, password: String) {
        repository.sendAuthRequest(username, password)
    }
} 