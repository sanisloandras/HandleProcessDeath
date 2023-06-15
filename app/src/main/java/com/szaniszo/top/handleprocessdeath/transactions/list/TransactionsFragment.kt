package com.szaniszo.top.handleprocessdeath.transactions.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.szaniszo.top.handleprocessdeath.databinding.FragmentTransactionsBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class TransactionsFragment : Fragment() {
    private val viewModel by viewModels<TransactionsViewModel>()

    private lateinit var viewDataBinding: FragmentTransactionsBinding

    private val adapter = TransactionListAdapter { transaction ->
        findNavController().navigate(
            TransactionsFragmentDirections.actionTransactionsFragmentToMakeTransactionFragment(
                transaction.accountNumber,
                transaction.amount
            )
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = FragmentTransactionsBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner

        viewDataBinding.rvTransactions.adapter = this.adapter

        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.transactions.collect {
                    adapter.submitList(it)
                }
            }
        }
    }
}