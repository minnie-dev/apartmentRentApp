package com.housepriceapp.houseprice.search

import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

interface SearchAPI {
    @GET("v2/local/search/keyword.json")
    fun getSearch(
        @Header("Authorization") key: String,     // 카카오 API 인증키 [필수]
        @Query("query") query: String,
        //@Query("category_group_code") category_group_code: String
    ) : Single<PlaceSearch>
}