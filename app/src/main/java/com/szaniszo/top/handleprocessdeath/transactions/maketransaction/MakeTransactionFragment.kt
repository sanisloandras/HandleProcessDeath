package com.szaniszo.top.handleprocessdeath.transactions.maketransaction

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.szaniszo.top.handleprocessdeath.databinding.MakeTransactionFragmentBinding

class MakeTransactionFragment : Fragment() {
    private val viewModel by viewModels<MakeTransactionViewModel>()

    private lateinit var viewDataBinding: MakeTransactionFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = MakeTransactionFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
    }
}
