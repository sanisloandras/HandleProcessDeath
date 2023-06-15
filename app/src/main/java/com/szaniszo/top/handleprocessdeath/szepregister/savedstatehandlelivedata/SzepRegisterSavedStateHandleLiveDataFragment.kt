package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandlelivedata

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.szaniszo.top.handleprocessdeath.databinding.SzepRegisterSavedStateHandleExtFragmentBinding
import com.szaniszo.top.handleprocessdeath.databinding.SzepRegisterSavedStateHandleLiveDataFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SzepRegisterSavedStateHandleLiveDataFragment : Fragment() {
    private val viewModel by viewModels<SzepRegisterSavedStateHandleLiveDataViewModel>()

    private lateinit var viewDataBinding: SzepRegisterSavedStateHandleLiveDataFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = SzepRegisterSavedStateHandleLiveDataFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
    }
}