package com.example.coinmarketapplication

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.viewModelScope
import com.example.coin_data.Instance
import com.example.coin_data.model.Data
import com.example.coinmarketapplication.roomdb.CoinDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoinViewModel(
    application: Application
) : AndroidViewModel(application) {
    private var coinRepository = Instance.getCoinRepository()
    private val coinMutableFlow = MutableStateFlow<List<Data>>(emptyList())

    val coinFlow: Flow<List<Data>> = coinMutableFlow

    init {
        viewModelScope.launch {
            val roomDao = CoinDataBase.getDatabase(application).getRoomDao()
            roomDao.insertData(coinRepository.getCoinData().data)
            coinMutableFlow.value = roomDao.getData()
        }
    }
}


