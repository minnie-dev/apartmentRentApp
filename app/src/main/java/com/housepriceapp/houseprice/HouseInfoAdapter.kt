package com.housepriceapp.houseprice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.housepriceapp.houseprice.data.Item
import com.housepriceapp.houseprice.databinding.ItemLegaldongBinding

class HouseInfoAdapter(var list : List<Item>) : RecyclerView.Adapter<HouseInfoAdapter.ViewHolder>() {

    lateinit var binding: ItemLegaldongBinding

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLegaldongBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        binding.legalText.text = list[position].apart
    }

    override fun getItemCount(): Int {
        return list.size
    }

    override fun getItemViewType(position: Int): Int {
        return position
    }


    inner class ViewHolder(binding: ItemLegaldongBinding) : RecyclerView.ViewHolder(binding.root) {

    }
}