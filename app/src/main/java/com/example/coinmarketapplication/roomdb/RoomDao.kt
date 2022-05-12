package com.example.coinmarketapplication.roomdb

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.coin_data.model.Data
import com.example.coin_data.model.ExampleJson2KtKotlin
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

        @Insert
        suspend fun insertData(data:List<Data>)

        @Query("SELECT * FROM Coin_table")
        suspend fun getData(): Flow<List<Data>>

}