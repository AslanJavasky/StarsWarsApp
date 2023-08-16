package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.planetFragment

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aslanjavasky.montekrist_test.starswars.data.network.api.RetrofitInstance
import com.aslanjavasky.montekrist_test.starswars.data.network.dto.PeopleDto
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.models.PlanetItem
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.GetPagerWithPeopleUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.GetPagerWithPlanetsUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.RemovePeopleItemUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.RemovePlanetItemUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.SavePeopleItemToDbUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.SavePlanetItemToDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
//import com.aslanjavasky.montekrist_test.starswars.data.network.dto.PeopleDto
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

class PlanetsViewModel @Inject constructor(
    private val useCase: GetPagerWithPlanetsUseCase,
    private val saveItemUseCase: SavePlanetItemToDbUseCase,
    private val removeItemUseCase: RemovePlanetItemUseCase,
) : ViewModel() {

    val items: Flow<PagingData<PlanetItem>> = useCase()
        .flow
        .cachedIn(viewModelScope)

    fun saveItem(planetItem: PlanetItem){
        viewModelScope.launch(Dispatchers.IO) {
            saveItemUseCase(planetItem.copy(isFavourite = true))
        }
    }

    fun removeItem(planetItem: PlanetItem) {
        viewModelScope.launch(Dispatchers.IO) {
            removeItemUseCase(planetItem.copy(isFavourite = false))
        }
    }
}