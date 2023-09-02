package com.example.challengemf.viewModel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemf.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.apiService

    fun getCharacters(): LiveData<List<Character>> {
        val data = MutableLiveData<List<Character>>()
        apiService.getCharacters().enqueue(object : Callback<List<Character>> {
            override fun onResponse(
                call: Call<List<Character>>,
                response: Response<List<Character>>
            ) {
                if (response.isSuccessful) {
                    data.value = response.body()
                }
            }

            override fun onFailure(call: Call<List<Character>>, t: Throwable) {
                // Handle error
            }
        })
        return data
    }
}
