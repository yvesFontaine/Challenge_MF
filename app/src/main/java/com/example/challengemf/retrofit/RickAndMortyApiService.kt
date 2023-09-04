package com.example.challengemf.retrofit

import com.example.challengemf.model.Character
import com.example.challengemf.model.Episode
import com.example.challengemf.model.Location
import retrofit2.Call
import retrofit2.http.GET

interface RickAndMortyApiService {
    @GET("character")
    fun getCharacters(): Call<List<Character>>

    @GET("location")
    fun getLocations(): Call<List<Location>>

    @GET("episode")
    fun getEpisodes(): Call<List<Episode>>
}
