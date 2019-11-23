package com.academy.hackathonapp.view.spending

import androidx.lifecycle.MutableLiveData
import com.academy.hackathonapp.db.model.Expense
import com.academy.hackathonapp.dependency.DataStorage
import com.academy.hackathonapp.mvvm.Event
import com.academy.hackathonapp.mvvm.viewModel.BaseViewModel

class SpendingViewModel : BaseViewModel() {

    val expenses = MutableLiveData<Event<List<Expense>>>()

    fun loadExpenses() {
        requestWithLiveData(expenses){
            DataStorage.expenseRepository.getAllExpenses()
        }
    }
}