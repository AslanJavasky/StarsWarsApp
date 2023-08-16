package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.shipFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.ShipItem
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.GetPagerWithShipsUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.RemovePeopleItemUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.RemoveShipItemToDbUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.SavePeopleItemToDbUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.SaveShipItemToDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject

class ShipViewModel @Inject constructor(
    private val useCase: GetPagerWithShipsUseCase,
    private val saveItemUseCase: SaveShipItemToDbUseCase,
    private val removeItemUseCase: RemoveShipItemToDbUseCase,
) : ViewModel() {

    val items: Flow<PagingData<ShipItem>> = useCase()
        .flow
        .cachedIn(viewModelScope)


    fun saveItem(shipItem: ShipItem){
        viewModelScope.launch(Dispatchers.IO) {
            saveItemUseCase(shipItem.copy(isFavourite = true))
        }
    }

    fun removeItem(shipItem: ShipItem) {
        viewModelScope.launch(Dispatchers.IO) {
            removeItemUseCase(shipItem.copy(isFavourite = false))
        }
    }

}