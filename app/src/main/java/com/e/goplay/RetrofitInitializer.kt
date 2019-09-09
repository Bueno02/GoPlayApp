package com.e.goplay

import com.e.goplay.service.GameService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://192.168.56.1:3000/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun gameService() = retrofit.create(GameService::class.java)
    }