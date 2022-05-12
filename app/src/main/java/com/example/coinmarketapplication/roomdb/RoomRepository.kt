package com.example.coinmarketapplication.roomdb


import com.example.coin_data.model.Data
import com.example.coin_data.model.ExampleJson2KtKotlin
import java.util.concurrent.Flow

class RoomRepository(private val roomDao: RoomDao){

    suspend fun insertData(data:List<Data>) {
        roomDao.insertData(data)
    }

    suspend fun getData() {
        roomDao.getData()



        //just to check

    }
}

