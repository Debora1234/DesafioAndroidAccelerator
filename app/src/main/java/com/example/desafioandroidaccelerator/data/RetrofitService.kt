package com.example.desafioandroidaccelerator.data

import com.example.desafioandroidaccelerator.data.model.gifTrending
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Query

//identificamos estructuras de las peticiones del servidor
interface RetrofitService {
    //recuperaremos datos
    @GET("/v1/gifs/trending")
    suspend fun getTrendingGifs(
        @Query("api_key") apiKey: String,
    ): gifTrending

}
object RetrofitServiceFactory {
    fun makeRetrofitService(): RetrofitService {
        return Retrofit.Builder()
            .baseUrl("https://api.giphy.com/")
            .addConverterFactory(GsonConverterFactory.create())
            .build().create(RetrofitService::class.java)
    }
}