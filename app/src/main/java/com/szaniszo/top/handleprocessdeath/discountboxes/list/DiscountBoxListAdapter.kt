package com.szaniszo.top.handleprocessdeath.discountboxes.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxListItemBinding

class DiscountBoxListAdapter :
    ListAdapter<DiscountBox, DiscountBoxListAdapter.VH>(object : DiffUtil.ItemCallback<DiscountBox>() {
        override fun areItemsTheSame(oldItem: DiscountBox, newItem: DiscountBox): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: DiscountBox, newItem: DiscountBox): Boolean {
            return oldItem == newItem
        }
    }) {

    inner class VH(val binding: DiscountBoxListItemBinding) : ViewHolder(binding.root) {

        fun bind(discountBox: DiscountBox) {
            binding.data = discountBox
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(
            DiscountBoxListItemBinding.inflate(
                LayoutInflater.from(parent.context), parent, false
            )
        )
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}