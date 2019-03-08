package com.kotlin.example.model


data class Response(
    val `data`: Data,
    val message: String,
    val success: Boolean
)

data class Data(
    val profile_image: String
)