package com.szaniszo.top.handleprocessdeath.discountboxes.list

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import androidx.lifecycle.Lifecycle
import androidx.lifecycle.lifecycleScope
import androidx.lifecycle.repeatOnLifecycle
import androidx.navigation.fragment.findNavController
import com.szaniszo.top.handleprocessdeath.R
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxListFragmentBinding
import com.szaniszo.top.handleprocessdeath.discountboxes.DiscountBoxViewModel
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.launch

@AndroidEntryPoint
class DiscountBoxListFragment : Fragment() {
    private val viewModel
        by hiltNavGraphViewModels<DiscountBoxViewModel>(R.id.graph_discount_boxes)

    private lateinit var viewDataBinding: DiscountBoxListFragmentBinding
    private val adapter = DiscountBoxListAdapter {
        viewModel.onDiscountBoxSelected(discountBoxId = it)
        findNavController().navigate(
            DiscountBoxListFragmentDirections.toDiscountBoxDetailsFragment(it)
        )
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DiscountBoxListFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
        viewDataBinding.rvDiscountBoxList.adapter = adapter
        collectDiscountBoxList()
    }

    private fun collectDiscountBoxList() {
        viewLifecycleOwner.lifecycleScope.launch {
            repeatOnLifecycle(Lifecycle.State.STARTED) {
                viewModel.discountBoxList.collect {
                    adapter.submitList(it)
                }
            }
        }
    }
}