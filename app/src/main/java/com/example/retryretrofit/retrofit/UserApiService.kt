package com.example.retryretrofit.retrofit

import retrofit2.Call
import retrofit2.http.GET




interface UserApiService {
    @Retry
    @GET("estados")
    fun getUsers(): Call<ArrayList<UserResponse?>>
}