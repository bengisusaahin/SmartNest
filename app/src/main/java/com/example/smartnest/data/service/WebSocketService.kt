package com.example.smartnest.data.service

import android.util.Log
import com.example.smartnest.data.dto.AuthParams
import com.example.smartnest.data.dto.WebSocketRequest
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.Response
import okhttp3.WebSocket
import okhttp3.WebSocketListener
import javax.inject.Inject
import javax.inject.Singleton
import com.example.smartnest.data.model.*
import com.google.gson.Gson

@Singleton
class WebSocketService @Inject constructor(){
    private var webSocket: WebSocket? = null
    private val _messages = Channel<String>(Channel.BUFFERED)
    val messages = _messages.receiveAsFlow()
    private val gson = Gson()

    fun connect(url: String) {
        val client = OkHttpClient()
        val request = Request.Builder().url(url).build()

        webSocket = client.newWebSocket(request, object : WebSocketListener() {
            // When the WebSocket connection is established
            override fun onOpen(webSocket: WebSocket, response: Response) {
                super.onOpen(webSocket, response)
                _messages.trySend("Connection established")
                Log.d("TAG", "onOpen: Connection established")
            }

            // Send the message to the WebSocket server
            override fun onMessage(webSocket: WebSocket, text: String) {
                try {
                    val response = gson.fromJson(text, WebSocketResponseDto::class.java)
                    _messages.trySend(response.toString())
                    Log.d("WebSocket", "Received message: $response")
                } catch (e: Exception) {
                    Log.e("WebSocket", "Error parsing message: ${e.message}")
                }
            }

            override fun onClosing(webSocket: WebSocket, code: Int, reason: String) {
                super.onClosing(webSocket, code, reason)
                _messages.trySend("Connection closing: $reason")
                Log.d("TAG", "onClosing: Connection closing with code $code, reason: $reason")
                webSocket.close(1000, null)
            }

            override fun onFailure(webSocket: WebSocket, t: Throwable, response: Response?) {
                _messages.trySend("Error: ${t.message}")
            }
        })
    }

    fun sendAuthRequest(username: String, password: String) {
        val authParams = AuthParams(username, password)
        val request = WebSocketRequest(
            id = 8,
            params = listOf(authParams),
            method = "Authenticate"
        )
        val jsonRequest = gson.toJson(request)
        webSocket?.send(jsonRequest)
    }

    fun sendMessage(message: String) {
        webSocket?.send(message)
    }

    fun close() {
        webSocket?.close(NORMAL_CLOSURE_STATUS, null)
        webSocket = null
        _messages.close()
    }

    companion object {
        private const val NORMAL_CLOSURE_STATUS = 1000
    }
}