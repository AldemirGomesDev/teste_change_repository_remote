package com.example.retryretrofit.retrofit

import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class RetrofitClient {

    companion object {

        private val BASE_URL = "https://servicodados.ibge.gov.br/api/v1/localidades/"

        private var retrofit: Retrofit? = null

        fun getApiService(): UserApiService {
            if (retrofit == null) {
                retrofit = Retrofit.Builder()
                    .baseUrl(BASE_URL)
                    .addCallAdapterFactory(RetryCallAdapterFactory.create())
                    .addConverterFactory(GsonConverterFactory.create())
                    .build()
            }
            return retrofit!!.create(UserApiService::class.java)
        }

    }

}