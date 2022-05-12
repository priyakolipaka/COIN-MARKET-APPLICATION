package com.example.coinmarketapplication.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coin_data.model.Data
import com.example.coin_data.model.ExampleJson2KtKotlin

@Database(entities = [Data::class], version = 1)
abstract class CoinDataBase: RoomDatabase() {
    abstract fun getRoomDao(): RoomDao

    companion object {
        private var INSTANCE: CoinDataBase? = null
        fun getDatabase(context: Context): CoinDataBase {
            return INSTANCE?: synchronized(this) {
                val instance= Room.databaseBuilder(
                    context.applicationContext,
                    CoinDataBase::class.java,
                    "Coin_table"
                ).build()
                INSTANCE= instance
                instance
            }
        }
    }

}