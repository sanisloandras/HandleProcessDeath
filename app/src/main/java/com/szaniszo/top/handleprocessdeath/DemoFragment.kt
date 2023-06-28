package com.szaniszo.top.handleprocessdeath

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.navigation.fragment.findNavController
import com.szaniszo.top.handleprocessdeath.databinding.DemoFragmentBinding

class DemoFragment : Fragment() {
    private lateinit var viewDataBinding: DemoFragmentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        viewDataBinding = DemoFragmentBinding.inflate(inflater, container, false)
        return viewDataBinding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewDataBinding.szepRegisterSimple.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterFragment())
        }
        viewDataBinding.szepRegisterSavedStateHandle.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterSavedStateHandleFragment())
        }
        viewDataBinding.szepRegisterSavedStateHandleExt.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterSavedStateHandleExtFragment())
        }
        viewDataBinding.szepRegisterSavedStateHandleLiveData.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterSavedStateHandleLiveDataFragment())
        }
        viewDataBinding.transactions.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToTransactionsFragment())
        }
        viewDataBinding.discountBoxes.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.toGraphDiscountBoxes())
        }
        viewDataBinding.szepRegisterComposeUi.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterComposeFragment())
        }
        viewDataBinding.szepRegisterComposeVm.setOnClickListener {
            findNavController().navigate(DemoFragmentDirections.actionDemoFragmentToSzepRegisterComposeFragment2())
        }
    }
}