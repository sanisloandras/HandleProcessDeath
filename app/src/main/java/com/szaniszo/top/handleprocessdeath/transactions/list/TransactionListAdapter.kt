package com.szaniszo.top.handleprocessdeath.transactions.list

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.szaniszo.top.handleprocessdeath.databinding.ListItemPrevTransactionBinding
import com.szaniszo.top.handleprocessdeath.transactions.Transaction

class TransactionListAdapter(
    val clickHandler: (Transaction) -> Unit,
) : ListAdapter<Transaction, TransactionListAdapter.VH>(object : DiffUtil.ItemCallback<Transaction>() {
    override fun areItemsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Transaction, newItem: Transaction): Boolean {
        return oldItem == newItem
    }
}) {

    inner class VH(private val binding: ListItemPrevTransactionBinding) : RecyclerView.ViewHolder(binding.root) {

        init {
            binding.re.setOnClickListener {
                clickHandler(getItem(adapterPosition))
            }
        }

        fun bind(transaction: Transaction) {
            binding.data = transaction
            binding.executePendingBindings()
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): VH {
        return VH(ListItemPrevTransactionBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun onBindViewHolder(holder: VH, position: Int) {
        holder.bind(getItem(position))
    }
}