package com.example.smartnest.ui.firstpage

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.smartnest.domain.usecase.CloseWebSocketUseCase
import com.example.smartnest.domain.usecase.ConnectWebSocketUseCase
import com.example.smartnest.domain.usecase.ObserveWebSocketMessagesUseCase
import com.example.smartnest.domain.usecase.SendAuthRequestUseCase
import com.example.smartnest.domain.usecase.SendWebSocketMessageUseCase
import com.example.smartnest.domain.util.RootResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class WebSocketViewModel @Inject constructor(
    private val connectWebSocketUseCase: ConnectWebSocketUseCase,
    private val sendWebSocketMessageUseCase: SendWebSocketMessageUseCase,
    private val observeWebSocketMessagesUseCase: ObserveWebSocketMessagesUseCase,
    private val closeWebSocketUseCase: CloseWebSocketUseCase,
    private val sendAuthRequestUseCase: SendAuthRequestUseCase
) : ViewModel() {

    private val _messages = MutableStateFlow<RootResult<String>>(RootResult.Loading)
    val messages: StateFlow<RootResult<String>>
        get() = _messages

    fun connect(url: String) {
        connectWebSocketUseCase(url)
    }

    fun sendMessage(message: String) {
        sendWebSocketMessageUseCase(message)
    }

    fun observeMessages() {
        viewModelScope.launch {
            observeWebSocketMessagesUseCase().collect { result ->
                _messages.value = result
            }
        }
    }

    fun closeConnection() {
        closeWebSocketUseCase()
    }

    fun sendAuthRequest(username: String, password: String) {
        viewModelScope.launch {
            sendAuthRequestUseCase(username, password)
        }
    }
}
