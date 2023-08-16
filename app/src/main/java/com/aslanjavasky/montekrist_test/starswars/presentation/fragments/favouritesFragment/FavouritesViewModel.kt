package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.favouritesFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.aslanjavasky.montekrist_test.starswars.domain.models.FavouriteItem
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.GetFavouriteItemsUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.launch
import javax.inject.Inject

private const val TAG = "FavouritesViewModel"
class FavouritesViewModel @Inject constructor(
    private val useCase: GetFavouriteItemsUseCase
) : ViewModel() {



    private val _items=MutableStateFlow<List<FavouriteItem>>(emptyList())
    val items=_items.asStateFlow()

    init {
        refreshData()
    }

    fun refreshData() {
        viewModelScope.launch(Dispatchers.IO) {
            kotlin.runCatching {
                useCase()
            }.fold(
                onSuccess = { _items.value= it },
                onFailure = { Log.e(TAG, "${it.message}", it) }
            )
        }
    }

}