package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.favouritesFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class FavouriteViewModelFactory @Inject constructor(
    private val viewModel: FavouritesViewModel
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(FavouritesViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}