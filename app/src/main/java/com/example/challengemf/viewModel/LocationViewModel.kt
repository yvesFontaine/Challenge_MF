package com.example.challengemf.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemf.retrofit.RetrofitBuilder
import com.example.challengemf.model.Location
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class LocationViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.apiService

    fun getLocations(): LiveData<List<Location>> {
        val data = MutableLiveData<List<Location>>()
        apiService.getLocations().enqueue(object : Callback<List<Location>> {
            override fun onResponse(call: Call<List<Location>>, response: Response<List<Location>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Location>>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
