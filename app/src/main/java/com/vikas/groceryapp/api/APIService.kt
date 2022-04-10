package com.vikas.groceryapp.api

import com.vikas.groceryapp.data.GroceryModelResponse
import com.vikas.groceryapp.utilities.API_KEY
import com.vikas.groceryapp.utilities.RESOURCE_INDEX
import com.vikas.groceryapp.utilities.RESPONSE_TYPE
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import okhttp3.logging.HttpLoggingInterceptor.Level
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path
import retrofit2.http.Query

/**
 * Used to connect to the Grocery API to fetch photos
 */
interface APIService {

    @GET("resource/{resValue}")
    suspend fun getGrocery(
        @Path("resValue") resValue: String = RESOURCE_INDEX,
        @Query("filters") filters: String,
        @Query("offset") offset: Int,
        @Query("limit") limit: Int,
        @Query("api-key") query: String = API_KEY,
        @Query("format") format: String = RESPONSE_TYPE
    ): GroceryModelResponse

    companion object {
        private const val BASE_URL = "https://api.data.gov.in/"

        fun create(): APIService {
            val logger = HttpLoggingInterceptor()
            logger.setLevel(Level.BASIC)

            val client = OkHttpClient.Builder()
                .addInterceptor(logger)
                .build()

            return Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(client)
                .addConverterFactory(GsonConverterFactory.create())
                .build()
                .create(APIService::class.java)
        }
    }
}
