package com.example.coinmarketapplication.roomDatabase

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.coin_data.Instance
import com.example.coin_data.model.Data

@Database(entities = [Data::class], version = 1)
abstract class CoinDataBase : RoomDatabase() {



    companion object {
        private var INSTANCE: CoinDataBase? = null
        fun getDatabase(context: Context) {
            if (INSTANCE == null) {
                INSTANCE=Room.databaseBuilder(
                    context,
                    CoinDataBase::class.java,
                    "CoinDataDB"
                ).build()

            }
        }
    }
}




