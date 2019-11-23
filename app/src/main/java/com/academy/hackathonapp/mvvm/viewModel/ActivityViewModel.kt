package com.academy.hackathonapp.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.viewModelScope
import com.academy.hackathonapp.data.network.Api
import com.academy.hackathonapp.data.network.NetworkService
import com.academy.hackathonapp.db.model.Category
import com.academy.hackathonapp.db.model.Currency
import com.academy.hackathonapp.repository.CategoryRepository
import com.academy.hackathonapp.repository.CurrencyRepository
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class ActivityViewModel(
    private val categoryRepository: CategoryRepository,
    private val currencyRepository: CurrencyRepository
) : BaseViewModel() {

    var api: Api = NetworkService.retrofitService()

    val currencies = MutableLiveData<List<Currency>>()
    val categories = MutableLiveData<List<Category>>()

    init {
        getCurrencies()
        getCategories()
    }

    private fun getCurrencies() {
        viewModelScope.launch(Dispatchers.IO) {
            currencies.postValue(currencyRepository.getAll())
        }
    }

    private fun getCategories() {
        viewModelScope.launch(Dispatchers.IO) {
            categories.postValue(categoryRepository.getAllCategories())
        }
    }
}

class ActivityViewModelFactory(
    private val categoryRepository: CategoryRepository,
    private val currencyRepository: CurrencyRepository
) : ViewModelProvider.Factory {

    override fun <T : ViewModel?> create(modelClass: Class<T>): T {
        return if (modelClass == ActivityViewModel::class.java) {
            @Suppress("UNCHECKED_CAST")
            ActivityViewModel(
                categoryRepository,
                currencyRepository
            ) as T
        } else {
            throw IllegalArgumentException()
        }
    }
}