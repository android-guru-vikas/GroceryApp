package com.vikas.groceryapp.viewmodels

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.paging.PagingData
import androidx.paging.cachedIn
import com.vikas.groceryapp.data.GroceryRepository
import com.vikas.groceryapp.data.Record
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

@HiltViewModel
class GroceryListViewModel @Inject internal constructor(
    private val repository: GroceryRepository
) : ViewModel() {

    fun getGroceries(queryString: String): Flow<PagingData<Record>> {
        return repository.getGroceryItems(queryString).cachedIn(viewModelScope)
    }
}
