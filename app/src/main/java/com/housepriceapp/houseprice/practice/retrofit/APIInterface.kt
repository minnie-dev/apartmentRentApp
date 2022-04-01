package com.housepriceapp.houseprice.practice.retrofit

import com.housepriceapp.houseprice.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface APIInterface {
    @GET("KorService/locationBasedList")
    fun getInfo(
        @Query("numOfRows") numOfRows: Int,
        @Query("pageNo") pageNo: Int,
        @Query("MobileOS") MobileOS: String,
        @Query("MobileApp") MobileApp: String,
        @Query("arrange") arrange: String,
        @Query("contentTypeId") contentTypeId: Int,
        @Query("mapX") mapX: Double,
        @Query("mapY") mapY: Double,
        @Query("radius") radius: Int,
        @Query("listYN") listYN: String,
        @Query("ServiceKey") ServiceKey: String = BuildConfig.API_KEY
    ): Single<LocationDTO>

}