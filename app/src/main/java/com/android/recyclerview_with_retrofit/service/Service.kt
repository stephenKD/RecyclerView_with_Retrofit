package com.android.recyclerview_with_retrofit.service

import android.util.Log
import com.android.recyclerview_with_retrofit.model.AllResponse

import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

interface Service {
    @Headers("accept: application/json")
    @GET("{lang}/Attractions/All")
    fun getAll(@Path("lang") lang: String, @Query("page") page: Int): Call<AllResponse>

    @Headers("accept: application/json")
    @GET("{lang}/Attractions/All")
    suspend fun getAllSuspend(@Path("lang") lang: String, @Query("page") page: Int): AllResponse
}

class NetworkManager {
    val retrofit: Retrofit

    init {
        val interceptor = HttpLoggingInterceptor { message -> Log.i("Retrofit", message) }
        interceptor.level = HttpLoggingInterceptor.Level.BODY
        val okHttpClient = OkHttpClient.Builder()
            .addInterceptor(interceptor)
            .build()

        retrofit = Retrofit.Builder()
            .baseUrl("https://www.travel.taipei/open-api/")
            .addConverterFactory(GsonConverterFactory.create())
            .client(okHttpClient)
            .build()
    }

    companion object {
        private val manager = NetworkManager()
        val client: Retrofit
            get() = manager.retrofit
    }


}

