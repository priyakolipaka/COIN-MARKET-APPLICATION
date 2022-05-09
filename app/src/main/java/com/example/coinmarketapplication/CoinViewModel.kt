package com.example.coinmarketapplication

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coin_data.Instance
import com.example.coin_data.model.ExampleJson2KtKotlin
import com.example.coinmarketapplication.roomDatabase.CoinDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

abstract class CoinViewModel(): ViewModel() {
    private var coinRepository = Instance.getCoinRepository()
    //private abstract val CoinDataBase : CoinDataBase


    private val coinMutableFlow = MutableStateFlow<ExampleJson2KtKotlin?>(null)

    val coinFlow : Flow<ExampleJson2KtKotlin?> = coinMutableFlow

    init {
        viewModelScope.launch {
            coinMutableFlow.value = coinRepository.getCoinData()
        }
    }

}
