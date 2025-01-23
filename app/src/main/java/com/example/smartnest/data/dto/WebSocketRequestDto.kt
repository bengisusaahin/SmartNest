package com.example.smartnest.data.dto

data class WebSocketRequest(
    val isRequest: Boolean = true,
    val id: Int,
    val params: List<Any>,
    val method: String
)
