package com.housepriceapp.houseprice

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.housepriceapp.houseprice.databinding.ItemLegaldongBinding
import com.housepriceapp.houseprice.room.LegalDongCode

class LegalDongCodeAdapter(val legalDongCodeList: List<LegalDongCode>) :
    RecyclerView.Adapter<LegalDongCodeAdapter.ViewHolder>() {

    lateinit var binding: ItemLegaldongBinding

    //item click interface
    interface OnItemClickEventListener {
        fun onItemClick(name: String, position: Int)
    }
    private var mItemClickListener: OnItemClickEventListener? = null
    fun setItemClickListener(itemClickListener: OnItemClickEventListener) {
        mItemClickListener = itemClickListener
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        binding = ItemLegaldongBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int {
        return legalDongCodeList.size
    }

    // recyclerview item 오류
    override fun getItemViewType(position: Int): Int {
        return position
    }

    inner class ViewHolder(binding: ItemLegaldongBinding) : RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int){
            binding.legalText.text = legalDongCodeList[position].legalDong
            if(position!=RecyclerView.NO_POSITION){
                binding.root.setOnClickListener {
                    mItemClickListener?.onItemClick(
                        legalDongCodeList[position].legalDong,
                        position
                    )
                }
            }
        }
    }

}