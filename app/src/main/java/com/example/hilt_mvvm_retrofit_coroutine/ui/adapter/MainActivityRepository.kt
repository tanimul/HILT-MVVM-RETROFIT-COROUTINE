package com.example.hilt_mvvm_retrofit_coroutine.ui.adapter

import androidx.lifecycle.MutableLiveData
import com.example.hilt_mvvm_retrofit_coroutine.data.models.User
import com.example.hilt_mvvm_retrofit_coroutine.data.network.RetroInterface
import javax.inject.Inject

class MainActivityRepository @Inject constructor(private val retroInterface: RetroInterface) {
    suspend fun getUserDataList(query: String, liveData: MutableLiveData<List<User>>) {
        liveData.postValue(retroInterface.getSearchData(query).body()?.items!!)
    }

}