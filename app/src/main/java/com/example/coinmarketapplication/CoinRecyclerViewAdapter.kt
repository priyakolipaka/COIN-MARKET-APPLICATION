package com.example.coinmarketapplication

import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.coin_data.model.Data
import com.example.coinmarketapplication.databinding.CoinLayoutBinding


class CoinRecyclerViewAdapter(private val coinData: List<Data>) :
    RecyclerView.Adapter<CoinRecyclerViewAdapter.MyViewHolder>() {

    private lateinit var mListener: OnItemClickListener

    interface OnItemClickListener {
        fun onItemClick(position: Int)

    }

    fun setOnItemClickListener(listener: OnItemClickListener) {
        mListener = listener
    }

    class MyViewHolder(itemView: CoinLayoutBinding, listener: OnItemClickListener) :
        RecyclerView.ViewHolder(itemView.root) {

        val view1: TextView = itemView.price
        val view2: TextView = itemView.marketCap
        val view3: TextView = itemView.symbol
        val view4: TextView = itemView.volume24
        //  var data: Data? = itemView.data


        init {
            itemView.root.setOnClickListener {
                listener.onItemClick(adapterPosition)
            }
        }

    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val itemView = CoinLayoutBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return MyViewHolder(itemView, mListener)

    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        val currentItem = coinData[position]

        // holder.data = currentItem
        holder.view1.text = currentItem.quote?.USD?.price.toString()
        holder.view2.text = currentItem.quote?.USD?.marketCap.toString()
        holder.view3.text = currentItem.symbol
        holder.view4.text = currentItem.quote?.USD?.volume24h.toString()

    }

    override fun getItemCount(): Int {
        return coinData.size
    }

//    fun setOnItemClickListener(listener: AdapterView.OnItemClickListener) {
//
//    }
}

