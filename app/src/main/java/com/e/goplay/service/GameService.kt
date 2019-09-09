package com.e.goplay.service

import com.e.goplay.model.Game
import retrofit2.Call
import retrofit2.http.GET


interface GameService{
    @GET("users")
    fun list() : Call<List<Game>>
    fun busca() : Call<Game>

}