package com.szaniszo.top.handleprocessdeath.discountboxes.details

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.hilt.navigation.fragment.hiltNavGraphViewModels
import com.szaniszo.top.handleprocessdeath.R
import com.szaniszo.top.handleprocessdeath.databinding.DiscountBoxDetailsFragmentBinding
import com.szaniszo.top.handleprocessdeath.discountboxes.DiscountBoxViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class DiscountBoxDetailsFragment : Fragment() {
    private val viewModel
        by hiltNavGraphViewModels<DiscountBoxViewModel>(R.id.graph_discount_boxes)

    private lateinit var viewDataBinding: DiscountBoxDetailsFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DiscountBoxDetailsFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
    }
}