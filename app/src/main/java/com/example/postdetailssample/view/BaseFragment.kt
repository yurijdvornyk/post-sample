package com.example.postdetailssample.view

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AlertDialog
import androidx.fragment.app.Fragment
import com.example.postdetailssample.R
import com.example.postdetailssample.viewmodel.BaseViewModel

abstract class BaseFragment<VM : BaseViewModel> : Fragment() {

    abstract val viewModel: VM

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.errorMessageData.observe(viewLifecycleOwner) {
            showNoData()
            AlertDialog.Builder(requireContext())
                .setTitle(R.string.error)
                .setMessage(R.string.error_general_message)
                .setPositiveButton(R.string.retry) { _, _ ->
                    retry()
                }
                .setNegativeButton(R.string.cancel) { _, _ -> }
                .show()
        }
    }

    open fun retry() {}

    protected open fun showNoData() {}
}