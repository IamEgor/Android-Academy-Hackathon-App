package com.academy.hackathonapp.mvvm.viewModel

import androidx.lifecycle.MutableLiveData
import com.academy.hackathonapp.data.network.Api
import com.academy.hackathonapp.data.network.NetworkService
import com.academy.hackathonapp.mvvm.Event

class ActivityViewModel(
) : BaseViewModel() {

    var api: Api = NetworkService.retrofitService()


    val simpleLiveData = MutableLiveData<Event<Any>>()

    fun getUsers() {
        requestWithLiveData(simpleLiveData) {
            api.getUsdToday()
        }
    }


        }
