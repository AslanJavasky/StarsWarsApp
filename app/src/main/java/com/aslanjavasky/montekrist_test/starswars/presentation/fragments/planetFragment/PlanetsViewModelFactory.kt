package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.planetFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment.PeopleViewModel
import javax.inject.Inject

class PlanetsViewModelFactory  @Inject constructor(
    private val viewModel: PlanetsViewModel
) : ViewModelProvider.Factory{

    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(PlanetsViewModel::class.java)){
            return viewModel as T
        }
        throw IllegalArgumentException("Unknown class name: $modelClass")
    }
}