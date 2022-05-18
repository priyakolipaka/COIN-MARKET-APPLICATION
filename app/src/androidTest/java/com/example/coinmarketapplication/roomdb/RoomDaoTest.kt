package com.example.coinmarketapplication.roomdb

import androidx.room.Room
import androidx.test.core.app.ApplicationProvider
import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.filters.SmallTest
import com.example.coin_data.model.Data
import com.example.coin_data.model.Quote
import com.example.coin_data.model.USD
import com.google.common.truth.Truth.assertThat
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.runBlocking
import org.junit.After
import org.junit.Before
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalCoroutinesApi
@RunWith(AndroidJUnit4::class)
@SmallTest
class RoomDaoTest {


        private lateinit var database: CoinDataBase
        private lateinit var dao: RoomDao

        @Before
        fun setup() {
            database = Room.inMemoryDatabaseBuilder(
                ApplicationProvider.getApplicationContext(),
                CoinDataBase::class.java
            ).allowMainThreadQueries().build()
            dao = database.getRoomDao()
        }

        @After
        fun teardown() {
            database.close()
        }



        @Test
        fun insertData()= runBlocking{

            val data = listOf(
                Data("BTC", Quote(USD(123.0, 20.0,30.0,40.0))),
                Data("SHIB", Quote(USD(300.00,30.980,89.7,2.0))),
                Data("BUSD",Quote(USD(48.0,345.00,56.0,14.00)))
            )
            dao.insertData(data)

            val db = dao.getData()

            assertThat(db.size).isEqualTo(3)
            assertThat(db[1].symbol).isEqualTo("SHIB")
        }
}