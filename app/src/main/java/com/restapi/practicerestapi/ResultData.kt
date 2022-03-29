package com.restapi.practicerestapi

import com.tickaroo.tikxml.annotation.*

@Xml (name="response")
data class ResultData(
    @Element
    val header : Header,
    @Element
    val body : Body,
)

@Xml(name="header")
data class Header(
    @PropertyElement
    val resultCode : Int,
    @PropertyElement
    val resultMsg :String,
)

@Xml(name="body")
data class Body(
    @Element
    val item: Item, // 현황 데이터
)

@Xml
data class Item(
    @PropertyElement
    val sidoNm:String?, // 시도명
    @PropertyElement
    val sgguNm:String?, // 시군구명
    @PropertyElement
    val yadmNm:String?, // 기관명
    @PropertyElement
    val hospTyTpCd:String?, // 선정유형
    @PropertyElement
    val telno:String?, // 전화번호
    @PropertyElement
    val adtFrDd:String?, // 운영가능일자
    @PropertyElement
    val spclAdmTyCd:String? // 구분코드
)