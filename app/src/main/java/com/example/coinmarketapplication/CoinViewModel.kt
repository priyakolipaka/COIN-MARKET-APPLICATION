package com.example.coinmarketapplication

import android.app.Application
import android.content.Context
import android.net.ConnectivityManager
import android.net.ConnectivityManager.*
import android.net.NetworkCapabilities.*
import android.os.Build
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.coin_data.Instance
import com.example.coin_data.model.ExampleJson2KtKotlin
//import com.example.coinmarketapplication.roomDatabase.CoinDataBase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.launch

class CoinViewModel(
   // app: Application
): ViewModel() {
    private var coinRepository = Instance.getCoinRepository()
    //private abstract val CoinDataBase : CoinDataBase


    private val coinMutableFlow = MutableStateFlow<ExampleJson2KtKotlin?>(null)

    val coinFlow : Flow<ExampleJson2KtKotlin?> = coinMutableFlow

    init {
        viewModelScope.launch {
            coinMutableFlow.value = coinRepository.getCoinData()
        }
    }
    /*private fun hasInternetConnection() {
        val connectivityManager = getApplication<ErrorHandling>().getSystemService(
            Context.CONNECTIVITY_SERVICE
        ) as ConnectivityManager
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            val activeNetwork = connectivityManager.activeNetwork ?: return false
            val capabilities =
                connectivityManager.getNetworkCapabilities(activeNetwork) ?: return false
            return when {
                capabilities.hasTransport(TRANSPORT_WIFI) -> true
                capabilities.hasTransport(TRANSPORT_CELLULAR) -> true
                capabilities.hasTransport(TRANSPORT_ETHERNET) -> true
                else -> false
            }
        } else {
            connectivityManager.activeNetworkInfo?.run {
                return@run when (type) {
                    TYPE_WIFI -> true
                    TYPE_MOBILE -> true
                    TYPE_ETHERNET -> true
                    else -> {

                    }
                }
            }
        }

   */
}


