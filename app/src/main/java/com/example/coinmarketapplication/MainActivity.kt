package com.example.coinmarketapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.lifecycleScope
import androidx.recyclerview.widget.GridLayoutManager
import com.example.coinmarketapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    private lateinit var coinViewModel: CoinViewModel

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        coinViewModel = ViewModelProvider(this)[CoinViewModel::class.java]

        val manager = GridLayoutManager(applicationContext, 1)

        lifecycleScope.launchWhenStarted {

            binding.recyclerView.apply {
                coinViewModel.coinFlow.collect { coinData ->
                    val adapter = CoinRecyclerViewAdapter(coinData)
                    this.adapter = adapter
                    adapter.setOnItemClickListener(object :
                        CoinRecyclerViewAdapter.OnItemClickListener {
                            override fun onItemClick(position: Int) {
                                Toast.makeText(
                                    context,
                                    "market_cap_dominance of ${coinData[position].symbol}  is ${coinData[position].quote?.USD?.marketCapDominance}",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }
                        }
                    )

                    layoutManager = manager

                }
            }
        }
    }


}


