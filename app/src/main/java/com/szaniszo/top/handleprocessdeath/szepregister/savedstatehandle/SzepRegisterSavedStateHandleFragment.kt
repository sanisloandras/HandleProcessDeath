package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandle

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.szaniszo.top.handleprocessdeath.databinding.SzepRegisterFragmentBinding
import com.szaniszo.top.handleprocessdeath.databinding.SzepRegisterSavedStateHandleFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SzepRegisterSavedStateHandleFragment : Fragment() {
    private val viewModel by viewModels<SzepRegisterSavedStateHandleViewModel>()

    private lateinit var viewDataBinding: SzepRegisterSavedStateHandleFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = SzepRegisterSavedStateHandleFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
    }
}