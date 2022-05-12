package com.example.coin_data.model

//import androidx.room.Entity
//import androidx.room.PrimaryKey

import androidx.room.Entity
import androidx.room.PrimaryKey
import androidx.room.TypeConverters
import com.google.gson.annotations.SerializedName
import retrofit2.Converter

@Entity(tableName = "Coin_table")
data class Data (


    @PrimaryKey
    @SerializedName("symbol"     ) var symbol                        : String = "",

    //@TypeConverters(Converter::class)
    @SerializedName("quote"      ) var quote                         : Quote?         = null


)