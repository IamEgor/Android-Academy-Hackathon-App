package com.academy.hackathonapp.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import com.academy.hackathonapp.data.model.Users
import com.academy.hackathonapp.mvvm.Event

class ActivityViewModel : BaseViewModel() {

    val simpleLiveData = MutableLiveData<Event<Any>>()

    fun getUsers() {
        requestWithLiveData(simpleLiveData) {
            api.getUsdToday()
        }
    }

    fun getUsersError(page: Int, callback: (data: Event<Users>) -> Unit) {
        requestWithCallback({
            api.getUsersError(
                page = page
            )
        }) {
            callback(it)
        }
    }
}