package com.example.coin_data.api

import com.example.coin_data.model.ExampleJson2KtKotlin
import retrofit2.http.GET
import retrofit2.http.Headers

interface CoinApi{
    @Headers("X-CMC_PRO_API_KEY: 48b26b53-8e34-4eca-8208-297f9ee460fb")
    @GET("cryptocurrency/listings/latest")
    suspend fun getCoinData() : ExampleJson2KtKotlin
}