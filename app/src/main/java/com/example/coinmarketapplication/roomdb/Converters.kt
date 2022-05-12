package com.example.coinmarketapplication.roomdb

import androidx.room.TypeConverter
import com.example.coin_data.model.Quote
import com.example.coin_data.model.USD

class Converters {
    @TypeConverter
    fun fromSource(quote: Quote): USD? {
        return quote.USD

    }

    @TypeConverter
    fun toSource(USD:USD? ):  Quote{
        return Quote(USD)

    }



    /*@TypeConverter
    fun fromSources(usd: USD): USD?{
        return usd

    }*/
}