package com.example.coin_data

import com.example.coin_data.api.CoinApi
import com.example.coin_data.repository.CoinRepositoryImpl
import okhttp3.OkHttpClient
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


object Instance {
    private const val BASE_URL = "https://pro-api.coinmarketcap.com/v1/"

    fun getCoinRepository(): CoinRepositoryImpl {

        val okHttpClient = OkHttpClient.Builder().build()
        val converterFactory = GsonConverterFactory.create()
        val retrofit = Retrofit.Builder().addConverterFactory(converterFactory).baseUrl(BASE_URL)
            .client(okHttpClient).build()
        val CoinApi = retrofit.create(CoinApi::class.java)
        return CoinRepositoryImpl(CoinApi)
    }
}


