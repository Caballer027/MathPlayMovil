package com.caballero.leo.mathplay.data.model

data class RegisterRequest(
    val nombre: String,
    val email: String,
    val fechaNacimiento: String,
    val password: String
)