package com.szaniszo.top.handleprocessdeath.szepregister.savedstatehandleext

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.szaniszo.top.handleprocessdeath.databinding.SzepRegisterSavedStateHandleExtFragmentBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class SzepRegistrationSavedStateHandleExtFragment : Fragment() {
    private val viewModel by viewModels<SzepCardRegistrationSavedStateHandleExtViewModel>()

    private lateinit var viewDataBinding: SzepRegisterSavedStateHandleExtFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = SzepRegisterSavedStateHandleExtFragmentBinding.inflate(inflater, container, false).apply {
            vm = viewModel
        }
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.lifecycleOwner = viewLifecycleOwner
    }
}