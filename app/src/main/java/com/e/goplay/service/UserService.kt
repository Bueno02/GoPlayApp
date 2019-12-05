package com.e.goplay.service

import com.e.goplay.model.User
import retrofit2.Call
import retrofit2.http.*


interface UserService{
        @GET("users")
        fun list(): Call<List<User>>

        @GET("users/{id}")
        fun find(@Path("id") id: Int): Call<User>

        @GET("users/{email}")
        fun valida(@Path ("email")email: String): Call<User>

        @POST("users")
        fun insert(@Body User: User): Call<User>

        @PUT("users/{id}")
        fun alter(@Path("id") id: Int,@Body User: User): Call<User>
    }