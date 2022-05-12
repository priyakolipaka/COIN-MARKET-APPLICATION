package com.example.coin_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName



data class ExampleJson2KtKotlin (

//  @SerializedName("status" ) var status : Status?

  @SerializedName("data"   ) var data   : List<Data> = emptyList()
)