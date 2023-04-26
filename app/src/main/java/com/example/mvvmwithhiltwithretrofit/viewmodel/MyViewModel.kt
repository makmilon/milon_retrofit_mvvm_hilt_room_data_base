package com.example.mvvmwithhiltwithretrofit.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.mvvmwithhiltwithretrofit.Repository.Repository
import com.example.mvvmwithhiltwithretrofit.netWork.dataClass.Product
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class MyViewModel @Inject constructor(private val repository: Repository) : ViewModel(){

    lateinit var liveData: MutableLiveData<List<Product>>

    init {
        liveData= MutableLiveData()
    }

    fun getLiveDataObserver():MutableLiveData<List<Product>>{
        return liveData
    }

    fun loadDataFromApi(){
        repository.makeApiCall(liveData)
    }

}