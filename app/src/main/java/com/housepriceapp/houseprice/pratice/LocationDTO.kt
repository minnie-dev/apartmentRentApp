package com.housepriceapp.houseprice.pratice

import com.tickaroo.tikxml.annotation.*

@Xml (name="response")
data class LocationDTO(
    @Element
    val header : Header?,
    @Element
    val body : Body?,
)

@Xml(name="header")
data class Header(
    @PropertyElement
    val resultCode : String?,
    @PropertyElement
    val resultMsg :String?,
)

@Xml(name="body")
data class Body(
    @Element
    val items: Items?, // 현황 데이터
    @PropertyElement
    val numOfRows : String?, // 한 페이지 결과 수
    @PropertyElement
    val pageNo : String?, // 페이지 번호
    @PropertyElement
    val totalCount : String? // 전체 결과 수
)

@Xml(name = "items")
data class Items(
    @Element(name = "item")
    val item:List<Item> // 세부항목
)


@Xml
data class Item(
    @PropertyElement
    val addr1:String?, // 주소
    @PropertyElement
    val addr2:String?, // 상세주소
    @PropertyElement
    val areacode:String?, // 지역코드
    @PropertyElement
    val booktour:String?, // 교과서 속 여행지 여부
    @PropertyElement
    val cat1:String?, // 대분류
    @PropertyElement
    val cat2:String?, // 중분류
    @PropertyElement
    val cat3:String?, // 소분류
    @PropertyElement
    val contentid:String?, // 콘텐츠ID
    @PropertyElement
    val contenttypeid:String?, // 콘텐츠타입ID
    @PropertyElement
    val createdtime:String?, // 등록일
    @PropertyElement
    val dist:String?, // 거리
    @PropertyElement
    val firstimage:String?, // 대표이미지(원본)
    @PropertyElement
    val firstimage2:String?, // 썸네일
    @PropertyElement
    val mapx:String?, // GPS X좌표
    @PropertyElement
    val mapy:String?, // GPS Y좌표
    @PropertyElement
    val mlevel:String?, // Map Level
    @PropertyElement
    val modifiedtime:String?, // 수정일
    @PropertyElement
    val readcount:String?, // 조회수
    @PropertyElement
    val sigungucode:String?, // 시군구코드
    @PropertyElement
    val tel:String?, // 전화번호
    @PropertyElement
    val title:String? // 제목
)