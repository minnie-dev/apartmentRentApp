package com.housepriceapp.houseprice.room

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "legalDongCode")
data class LegalDongCode(
    @PrimaryKey(autoGenerate = true)
    var Id:Int?,
    var legalDong:String,
    var code:Int,
)
