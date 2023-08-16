package com.aslanjavasky.montekrist_test.starswars.presentation.fragments.peopleFragment

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.aslanjavasky.montekrist_test.starswars.domain.models.PeopleItem
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.GetPagerWithPeopleUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.RemovePeopleItemUseCase
import com.aslanjavasky.montekrist_test.starswars.domain.usecases.SavePeopleItemToDbUseCase
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.launch
import javax.inject.Inject


class PeopleViewModel @Inject constructor(
    private val useCasePager: GetPagerWithPeopleUseCase,
    private val saveItemUseCase:SavePeopleItemToDbUseCase,
    private val removeItemUseCase: RemovePeopleItemUseCase,

    ) : ViewModel() {

    val items: Flow<PagingData<PeopleItem>> = useCasePager()
        .flow
        .cachedIn(viewModelScope)


    fun saveItem(peopleItem: PeopleItem){
        viewModelScope.launch(Dispatchers.IO) {
            saveItemUseCase(peopleItem.copy(isFavourite = true))
        }
    }

    fun removeItem(peopleItem: PeopleItem) {
        viewModelScope.launch(Dispatchers.IO) {
            removeItemUseCase(peopleItem.copy(isFavourite = false))
        }
    }
}