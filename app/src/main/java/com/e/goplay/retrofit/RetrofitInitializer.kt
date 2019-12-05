package com.e.goplay.retrofit

import com.e.goplay.service.GameService
import com.e.goplay.service.UserService
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class RetrofitInitializer {
    private val retrofit = Retrofit.Builder()
        .baseUrl("http://apigamego.herokuapp.com/")
        .addConverterFactory(GsonConverterFactory.create())
        .build()

    fun gameService() = retrofit.create(GameService::class.java)
    fun userService() = retrofit.create(UserService::class.java)
    }
