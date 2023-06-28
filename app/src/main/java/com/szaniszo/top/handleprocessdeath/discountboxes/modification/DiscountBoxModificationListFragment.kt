package com.szaniszo.top.handleprocessdeath.discountboxes.modification

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
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxModificationListFragmentBinding
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiscountBoxModificationListFragment : Fragment() {
    private val viewModel by viewModels<DiscountBoxModificationListViewModel>()

    private lateinit var viewDataBinding: DiscountBoxModificationListFragmentBinding

    private val adapter = DiscountBoxModificationListAdapter({
        findNavController().navigate(
            DiscountBoxModificationListFragmentDirections
                .actionDiscountBoxModificationListFragmentToDiscountBoxDetailsFragment(it)
        )
    }, {
        viewModel.onCheckChanged(discountBoxId = it)
    })

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DiscountBoxModificationListFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.rvDiscountBoxList.adapter = adapter
        collectList()
    }

    private fun collectList() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.discountBoxModificationList.collect {
                    adapter.submitList(it)
                }
            }
        }
    }
}
