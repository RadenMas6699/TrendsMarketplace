package com.radenmas.trendsmarketplace.network

import com.google.gson.GsonBuilder
import okhttp3.Interceptor
import okhttp3.JavaNetCookieJar
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import java.net.CookieHandler


/**
 * Created by RadenMas on 16/09/2022.
 */
object Retro {
    val shopee: APIShopee by lazy {
        val gson = GsonBuilder()
            .setLenient()
            .create()
        val retrofit = Retrofit.Builder()
            .baseUrl(Config.BASE_SHOPEE)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(APIShopee::class.java)
    }

    val blibli: APIBlibli by lazy {
        val gson = GsonBuilder()
            .setLenient()
            .create()

        val retrofit = Retrofit.Builder()
            .baseUrl(Config.BASE_BLIBLI)
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()

        retrofit.create(APIBlibli::class.java)
    }
}