package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import javax.inject.Inject

class PeopleViewModelFactory @Inject constructor(
    private val viewModel: PeopleViewModel
) :ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PeopleViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}