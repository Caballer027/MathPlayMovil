package com.caballero.leo.mathplay.data.network

import com.caballero.leo.mathplay.data.model.ApiResponse
import com.caballero.leo.mathplay.data.model.JwtResponse
import com.caballero.leo.mathplay.data.model.LoginRequest
import com.caballero.leo.mathplay.data.model.RegisterRequest
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.POST

interface AuthApi {
    @POST("api/auth/login")
    fun login(@Body request: LoginRequest): Call<JwtResponse>

    @POST("api/auth/register")
    fun register(@Body request: RegisterRequest): Call<ApiResponse>
}