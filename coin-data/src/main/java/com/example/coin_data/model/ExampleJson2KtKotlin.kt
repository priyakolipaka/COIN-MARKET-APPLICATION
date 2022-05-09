package com.example.coin_data.model

import com.google.gson.annotations.SerializedName

data class ExampleJson2KtKotlin (

//  @SerializedName("status" ) var status : Status?         = Status(),
  @SerializedName("data"   ) var data   : List<Data> = emptyList()
)