package com.example.smartnest.data.model

data class WebSocketResponseDto(
    val id: Int,
    val params: List<String>,
    val method: String,
    val error: String?,
    val isRequest: Boolean
) 