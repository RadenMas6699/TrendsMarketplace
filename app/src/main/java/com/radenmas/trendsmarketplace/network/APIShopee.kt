package com.radenmas.trendsmarketplace.network

import com.radenmas.trendsmarketplace.model.shopee.ResponseShopee
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by RadenMas on 16/09/2022.
 */
interface APIShopee {
    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @GET("api/v4/search/search_items")
    fun searchProductShopee(
        @Query("by") by: String,
        @Query("keyword") keyword: String,
        @Query("limit") limit: Int,
        @Query("newest") newest: Int,
        @Query("order") order: String,
        @Query("page_type") page_type: String,
        @Query("scenario") scenario: String,
        @Query("version") version: Int
    ): Call<ResponseShopee>
}