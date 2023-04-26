package com.example.mvvmwithhiltwithretrofit.Repository

import android.annotation.SuppressLint
import androidx.lifecycle.MutableLiveData
import androidx.recyclerview.widget.RecyclerView
import com.example.mvvmwithhiltwithretrofit.netWork.RetroInstance
import com.example.mvvmwithhiltwithretrofit.netWork.dataClass.Product
import com.example.mvvmwithhiltwithretrofit.netWork.dataClass.api
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import javax.inject.Inject

class Repository @Inject constructor(private val retroInstance: RetroInstance){

    @SuppressLint("SuspiciousIndentation")
    fun makeApiCall(liveData: MutableLiveData<List<Product>>){
      val call : Call<api> =  retroInstance.getDataFromAPI()
        call?.enqueue(object : Callback<api>{

            override fun onResponse(call: Call<api>, response: Response<api>) {
                liveData.postValue(response.body()?.products!!)
            }

            override fun onFailure(call: Call<api>, t: Throwable) {
                liveData.postValue(null)
            }
        })
    }


}


