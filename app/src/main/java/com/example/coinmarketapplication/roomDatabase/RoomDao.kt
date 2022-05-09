package com.example.coinmarketapplication.roomDatabase

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.coin_data.model.Data

@Dao
interface RoomDao {


    @Insert
    suspend fun insertData(data:List<Data>)

    @Query("SELECT * FROM CoinData")
    suspend fun getData():List<Data>


}