package com.restapi.practicerestapi

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
    val resultCode : Int?,
    @PropertyElement
    val resultMsg :String?,
)

@Xml(name="body")
data class Body(
    @Element
    val items: List<Item>?, // 현황 데이터
    @PropertyElement
    val numOfRows : Int?, // 한 페이지 결과 수
    @PropertyElement
    val pageNo : Int?, // 페이지 번호
    @PropertyElement
    val totalCount : Int? // 전체 결과 수
)

@Xml
data class Item(
    @PropertyElement
    val addr1:String?, // 주소
    @PropertyElement
    val addr2:String?, // 상세주소
    @PropertyElement
    val areacode:Int?, // 지역코드
/*    @PropertyElement
    val booktour:Int?, // 교과서 속 여행지 여부*/
    @PropertyElement
    val cat1:String?, // 대분류
    @PropertyElement
    val cat2:String?, // 중분류
    @PropertyElement
    val cat3:String?, // 소분류
    @PropertyElement
    val contentid:Int?, // 콘텐츠ID
    @PropertyElement
    val contenttypeid:Int?, // 콘텐츠타입ID
    @PropertyElement
    val createdtime:Int?, // 등록일
    @PropertyElement
    val dist:Int?, // 거리
    @PropertyElement
    val firstimage:String?, // 대표이미지(원본)
    @PropertyElement
    val firstimage2:String?, // 썸네일
    @PropertyElement
    val mapx:Double?, // GPS X좌표
    @PropertyElement
    val mapy:Double?, // GPS Y좌표
    @PropertyElement
    val mlevel:Int?, // Map Level
    @PropertyElement
    val modifiedtime:Int?, // 수정일
    @PropertyElement
    val readcount:Int?, // 조회수
    @PropertyElement
    val sigungucode:Int?, // 시군구코드
    @PropertyElement
    val tel:String?, // 전화번호
    @PropertyElement
    val title:String?, // 제목
)