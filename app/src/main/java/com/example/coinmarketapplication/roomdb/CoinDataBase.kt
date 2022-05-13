package com.example.coinmarketapplication.roomdb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.coin_data.model.Data

@Database(entities = [Data::class], version = 1, exportSchema = false)
@TypeConverters(Converters::class)
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