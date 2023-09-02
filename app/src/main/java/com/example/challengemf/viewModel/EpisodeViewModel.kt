package com.example.challengemf.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemf.retrofit.RetrofitBuilder
import com.example.challengemf.model.Episode
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class EpisodeViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.apiService

    fun getEpisodes(): LiveData<List<Episode>> {
        val data = MutableLiveData<List<Episode>>()
        apiService.getEpisodes().enqueue(object : Callback<List<Episode>> {
            override fun onResponse(call: Call<List<Episode>>, response: Response<List<Episode>>) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Episode>>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}