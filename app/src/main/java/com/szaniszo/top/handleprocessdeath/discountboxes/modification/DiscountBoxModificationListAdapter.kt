package com.szaniszo.top.handleprocessdeath.discountboxes.modification

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView.ViewHolder
import com.szaniszo.top.handleprocessdeath.R
import com.szaniszo.top.handleprocessdeath.data.model.DiscountBox
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxModificationGroupListItemBinding
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxModificationListItemBinding
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.BaseDiscountBoxModificationItem
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxGroupLabelListItem
import com.szaniszo.top.handleprocessdeath.discountboxes.modification.model.DiscountBoxModificationListItem
import java.lang.IllegalArgumentException

class DiscountBoxModificationListAdapter :
    ListAdapter<BaseDiscountBoxModificationItem, ViewHolder>(object :
        DiffUtil.ItemCallback<BaseDiscountBoxModificationItem>() {
        override fun areItemsTheSame(
            oldItem: BaseDiscountBoxModificationItem,
            newItem: BaseDiscountBoxModificationItem
        ): Boolean {
            return when {
                oldItem is DiscountBoxModificationListItem && newItem is DiscountBoxModificationListItem ->
                    oldItem.discountBox.id == newItem.discountBox.id

                else -> oldItem == newItem
            }
        }

        override fun areContentsTheSame(
            oldItem: BaseDiscountBoxModificationItem,
            newItem: BaseDiscountBoxModificationItem
        ): Boolean {
            return oldItem == newItem
        }
    }) {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val layoutInflater = LayoutInflater.from(parent.context)
        return when (viewType) {
            R.layout.discount_box_modification_list_item -> DiscountBoxModificationViewHolder(
                DiscountBoxModificationListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )
            R.layout.discount_box_modification_group_list_item -> GroupLabelViewHolder(
                DiscountBoxModificationGroupListItemBinding.inflate(
                    layoutInflater,
                    parent,
                    false
                )
            )

            else -> throw IllegalArgumentException()
        }
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        when (holder) {
            is DiscountBoxModificationViewHolder ->
                holder.bind((getItem(position) as DiscountBoxModificationListItem).discountBox)

            is GroupLabelViewHolder -> holder.bind((getItem(position) as DiscountBoxGroupLabelListItem).group)
        }
    }

    override fun getItemViewType(position: Int): Int {
        return when (getItem(position)) {
            is DiscountBoxModificationListItem -> R.layout.discount_box_modification_list_item
            is DiscountBoxGroupLabelListItem -> R.layout.discount_box_modification_group_list_item
            else -> super.getItemViewType(position)
        }
    }

    inner class GroupLabelViewHolder(val binding: DiscountBoxModificationGroupListItemBinding) :
        ViewHolder(binding.root) {

        fun bind(data: String) {
            binding.data = data
            binding.executePendingBindings()
        }
    }

    inner class DiscountBoxModificationViewHolder(val binding: DiscountBoxModificationListItemBinding) :
        ViewHolder(binding.root) {

        fun bind(data: DiscountBox) {
            binding.data = data
            binding.executePendingBindings()
        }
    }
}