package com.housepriceapp.houseprice.data

import com.housepriceapp.houseprice.BuildConfig
import io.reactivex.Single
import retrofit2.http.GET
import retrofit2.http.Query

interface RentAPIService {
    @GET("RTMSOBJSvc/getRTMSDataSvcAptRent")
    fun getInfo(
        @Query("LAWD_CD") areaCode: Int,
        @Query("DEAL_YMD") dealMonth: Int,
        @Query("_type") type: String,
        @Query("ServiceKey") ServiceKey: String = BuildConfig.API_KEY
    ): Single<RentDTO>
}