package com.radenmas.trendsmarketplace.network

import com.radenmas.trendsmarketplace.model.tokopedia.ResponseTokopedia
import retrofit2.Call
import retrofit2.http.Body
import retrofit2.http.Headers
import retrofit2.http.POST
import java.util.*


/**
 * Created by RadenMas on 16/09/2022.
 */
interface APITokopedia {

    @Headers(
        "Accept: application/json",
        "Content-Type: application/json"
    )
    @POST("DynamicSearchProductQuery")
    fun searchProductTokopedia(
        @Body body: String
    ): Call<ResponseTokopedia>
}