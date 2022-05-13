package com.example.coinmarketapplication.roomdb

import androidx.room.*
import com.example.coin_data.model.Data
import com.example.coin_data.model.ExampleJson2KtKotlin
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDao {

        @Insert(onConflict = OnConflictStrategy.REPLACE)
        suspend fun insertData(data:List<Data>)

        @Query("SELECT * FROM Coin_table")
        suspend fun getData(): List<Data>

}