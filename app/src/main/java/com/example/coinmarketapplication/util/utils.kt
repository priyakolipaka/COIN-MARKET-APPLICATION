package com.example.coinmarketapplication.util

import java.net.URL

class Utils {



        fun isValidString(symbol: String?): Boolean {
            if (symbol is String && symbol.isNullOrEmpty()) {
                return true
            }
            return false
        }
    }




