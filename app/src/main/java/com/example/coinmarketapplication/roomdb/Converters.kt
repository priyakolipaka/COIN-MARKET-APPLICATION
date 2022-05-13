package com.example.coinmarketapplication.roomdb

import androidx.room.TypeConverter
import com.example.coin_data.model.Quote
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken

class Converters {

    @TypeConverter
    fun fromSource(quote: Quote?): String? {
        val type = object: TypeToken<Quote>() {}.type
        return Gson().toJson(quote, type)
    }

    @TypeConverter
    fun toSource(quoteString: String?): Quote {
        val type = object: TypeToken<Quote>() {}.type
        return Gson().fromJson<Quote>(quoteString, type)
    }


}