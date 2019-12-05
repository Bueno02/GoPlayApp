package com.e.goplay.service

import com.e.goplay.model.Game
import retrofit2.Call
import retrofit2.http.*


interface GameService{
        @GET("games")
        fun list(): Call<List<Game>>

        @GET("games/{id}")
        fun find(@Path("id") id: Int): Call<Game>

        @POST("games")
        fun insert(@Body Game: Game): Call<Game>

        @PUT("games/{id}")
        fun alter(@Path("id") id: Int,@Body Game: Game): Call<Game>
    }