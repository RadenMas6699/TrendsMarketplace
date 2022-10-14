package com.radenmas.trendsmarketplace.network

import com.radenmas.trendsmarketplace.model.blibli.ResponseBlibli
import retrofit2.Call
import retrofit2.http.GET
import retrofit2.http.Headers
import retrofit2.http.Query

/**
 * Created by RadenMas on 16/09/2022.
 */
interface APIBlibli {
    @Headers(
        "Accept: application/json",
        "User-Agent: Mozilla/5.0 (iPhone; CPU iPhone OS 13_2_3 like Mac OS X) AppleWebKit/605.1.15 (KHTML, like Gecko) Version/13.0.3 Mobile/15E148 Safari/604.1",
        "Content-Type: application/json"
    )
    @GET("products")
    fun searchProductBlibli(
        @Query("sort") sort: Int,
        @Query("page") page: Int,
        @Query("searchTerm") searchTerm: String
    ): Call<ResponseBlibli>
}