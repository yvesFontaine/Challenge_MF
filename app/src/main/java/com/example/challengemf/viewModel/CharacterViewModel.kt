package com.example.challengemf.viewModel

import android.util.Log
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.challengemf.model.Character
import com.example.challengemf.retrofit.RetrofitBuilder
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class CharacterViewModel : ViewModel() {
    private val apiService = RetrofitBuilder.apiService
    private val data = MutableLiveData<List<Character>>()


//    fun getCharacters(): Observable<List<Character>> {
//        return Observable.create { emitter ->
//            apiService.getCharacters()
//                .enqueue(object : Callback<List<Character>> {
//                    override fun onResponse(
//                        call: Call<List<Character>>,
//                        response: Response<List<Character>>
//                    ) {
//                        if (response.isSuccessful) {
//                            emitter.onNext(response.body()!!)
//                            emitter.onComplete()
//                        } else {
//                            emitter.onError(Throwable("Error: ${response.code()}"))
//                        }
//                    }
//
//                    override fun onFailure(
//                        call: Call<List<Character>>,
//                        t: Throwable
//                    ) {
//                        emitter.onError(t)
//                    }
//                })
//        }
//    }


    fun getCharacters() {
        apiService.getCharacters()
            .enqueue(object : Callback<List<com.example.challengemf.model.Character>> {
                override fun onResponse(
                    call: Call<List<com.example.challengemf.model.Character>>,
                    response: Response<List<com.example.challengemf.model.Character>>
                ) {

                    Log.v(null,"TEMA frangio")
                    if (response.isSuccessful) {
                        data.postValue(response.body())
                    }
                }

                override fun onFailure(
                    call: Call<List<com.example.challengemf.model.Character>>,
                    t: Throwable
                ) {
                    // Handle error
                }
            })
    }


    fun getCharacterLiveData() : LiveData<List<Character>>{
        return data
    }
}
