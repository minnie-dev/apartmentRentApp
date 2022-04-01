package com.housepriceapp.houseprice.data

import com.google.gson.annotations.SerializedName
import com.tickaroo.tikxml.annotation.Element
import com.tickaroo.tikxml.annotation.PropertyElement
import com.tickaroo.tikxml.annotation.Xml

@Xml(name = "response")
data class RentDTO(
    @Element
    val header : Header,
    @Element
    val body:Body
)

@Xml(name = "header")
data class Header(
    @PropertyElement
    val resultCode:String,
    @PropertyElement
    val resultMsg:String
)

@Xml(name = "body")
data class Body(
    @PropertyElement
    val numOfRows:String,
    @PropertyElement
    val pageNo:String,
    @PropertyElement
    val totalCount:String,
    @Element
    val items:Items,
)

@Xml(name = "items")
data class Items(
    @Element
    val item:List<Item>,
)

@Xml(name = "item")
data class Item(
    @PropertyElement(name = "갱신요구권사용")val renewalRequest:String,
    @PropertyElement(name = "건축년도")val build:String,
    @PropertyElement(name = "계약구분")val contractType:String,
    @PropertyElement(name = "계약기간")val contractPeriod:String,
    @PropertyElement(name = "년")val year:String,
    @PropertyElement(name = "법정동")val dong:String,
    @PropertyElement(name = "보증금액")val bo_price:String,
    @PropertyElement(name = "아파트")val apart:String,
    @PropertyElement(name = "월")val month:String,
    @PropertyElement(name = "월세금액")val mo_price:String,
    @PropertyElement(name = "일")val day:String,
    @PropertyElement(name = "전용면적")val size:String,
    @PropertyElement(name = "종전계약보증금")val last_bo_price:String,
    @PropertyElement(name = "종전계약월세")val last_mo_price:String,
    @PropertyElement(name = "지번")val jibun:String,
    @PropertyElement(name = "지역코드")val areaCode :String,
    @PropertyElement(name = "층")val floor:String,
)

/*data class RentDTO(
    @SerializedName("header")val header:Header,
    @SerializedName("body")val body:Body
)

data class Header(
    @SerializedName("resultCode")val resultCode:String,
    @SerializedName("resultMsg")val resultMsg:String
)

data class Body(
    @SerializedName("numOfRows")val numOfRows:String,
    @SerializedName("pageNo")val pageNo:String,
    @SerializedName("totalCount")val totalCount:String,
    @SerializedName("items")val items:Items,
)

data class Items(
    @SerializedName("item")val item:List<Item>,
)

data class Item(
    @SerializedName("갱신요구권사용")val renewalRequest:String,
    @SerializedName("건축년도")val build:String,
    @SerializedName("계약구분")val contractType:String,
    @SerializedName("계약기간")val contractPeriod:String,
    @SerializedName("년")val year:String,
    @SerializedName("법정동")val dong:String,
    @SerializedName("보증금액")val bo_price:String,
    @SerializedName("아파트")val apart:String,
    @SerializedName("월")val month:String,
    @SerializedName("월세금액")val mo_price:String,
    @SerializedName("일")val day:String,
    @SerializedName("전용면적")val size:String,
    @SerializedName("종전계약보증금")val last_bo_price:String,
    @SerializedName("종전계약월세")val last_mo_price:String,
    @SerializedName("지번")val jibun:String,
    @SerializedName("지역코드")val areaCode :String,
    @SerializedName("층")val floor:String,
)*/
