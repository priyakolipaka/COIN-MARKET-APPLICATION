package com.example.coin_data.repository

import com.example.coin_data.api.CoinApi
import com.example.coin_data.model.ExampleJson2KtKotlin

interface CoinRepository{
    suspend fun getCoinData(): ExampleJson2KtKotlin


}
class CoinRepositoryImpl(
    private val CoinApi: CoinApi
): CoinRepository {
    override suspend fun getCoinData(): ExampleJson2KtKotlin {
        return CoinApi.getCoinData()

    }
}