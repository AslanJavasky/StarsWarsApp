package com.aslanjavasky.montekrist_test.starswars.data.network.api


import com.aslanjavasky.montekrist_test.starswars.data.network.dto.ResponsePeopleDto
import com.aslanjavasky.montekrist_test.starswars.data.network.dto.ResponsePlanetsDto
import com.aslanjavasky.montekrist_test.starswars.data.network.dto.ResponseShipsDto
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Path
import retrofit2.http.Query

const val BASE_URL = "https://swapi.dev/api/"

interface SearchDataApi {

    @GET("people")
    suspend fun getPeople(
        @Query("page") page: Int = 1,
        @Query("format") format:String="json"
    ): ResponsePeopleDto


    @GET("planets")
    suspend fun getPlanets(
        @Query("page") page: Int = 1,
        @Query("format") format:String="json"
    ): ResponsePlanetsDto

    @GET("starships")
    suspend fun getShips(
        @Query("page") page: Int = 1,
        @Query("format") format:String="json"
    ): ResponseShipsDto
}

object RetrofitInstance {

    private val retrofit = Retrofit.Builder()
        .client(
            OkHttpClient.Builder().addInterceptor(HttpLoggingInterceptor().also {
                it.level = HttpLoggingInterceptor.Level.BODY
            }).build()
        )
        .baseUrl(BASE_URL)
        .addConverterFactory(MoshiConverterFactory.create())
        .build()

    val searchDataApi: SearchDataApi =
        retrofit.create(SearchDataApi::class.java)
}