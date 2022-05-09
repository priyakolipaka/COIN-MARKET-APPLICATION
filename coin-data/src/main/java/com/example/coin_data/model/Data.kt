package com.example.coin_data.model

import androidx.room.Entity
import androidx.room.PrimaryKey

import com.google.gson.annotations.SerializedName

@Entity(tableName = "CoinData")
data class Data (

//  @SerializedName("id"                               ) var id                            : Int?              = null,
//  @SerializedName("name"                             ) var name                          : String?           = null,
  @PrimaryKey
  @SerializedName("symbol"                       ) var symbol                        : String?           = null,
//  @SerializedName("slug"                             ) var slug                          : String?           = null,
//  @SerializedName("num_market_pairs"                 ) var numMarketPairs                : Int?              = null,
//
//  @SerializedName("max_supply"                       ) var maxSupply                     : Int?              = null,
//  @SerializedName("circulating_supply"               ) var circulatingSupply             : Double?              = null,
//  @SerializedName("total_supply"                     ) var totalSupply                   : Double?              = null,
//  @SerializedName("platform"                         ) var platform                      : String?           = null,
//  @SerializedName("cmc_rank"                         ) var cmcRank                       : Int?              = null,
//  @SerializedName("self_reported_circulating_supply" ) var selfReportedCirculatingSupply : String?           = null,
//  @SerializedName("self_reported_market_cap"         ) var selfReportedMarketCap         : String?           = null,
//  @SerializedName("last_updated"                     ) var lastUpdated                   : String?           = null,
  @SerializedName("quote"                        ) var quote                         : Quote?            = Quote()

)