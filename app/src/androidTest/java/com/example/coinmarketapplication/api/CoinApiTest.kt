package com.example.coinmarketapplication.api

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.test.ext.junit.runners.AndroidJUnit4
import app.cash.turbine.test
import com.example.coin_data.Instance
import com.example.coin_data.model.Data
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.runBlocking
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class CoinApiTest {

    @get:Rule
    var rule = InstantTaskExecutorRule()

    private var coinRepository = Instance.getCoinRepository()
    private val coinMutableFlow = MutableStateFlow<List<Data>>(emptyList())

    val coinFlow: Flow<List<Data>> = coinMutableFlow

    @Before
    fun setup() {
        runBlocking {
            coinMutableFlow.value = coinRepository.getCoinData().data
        }
    }

    @Test
    fun checkAPI() {
        runBlocking {
            coinFlow.test {
                val data = awaitItem()
                assertThat(data).isNotNull()
                assertThat(data).isNotEmpty()
                assertThat(data[0].symbol).isEqualTo("BTC")
            }
        }
    }
}