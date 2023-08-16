package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.shipFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class ShipsViewModelFactory @Inject constructor(
    private val viewModel: ShipViewModel
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(ShipViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}