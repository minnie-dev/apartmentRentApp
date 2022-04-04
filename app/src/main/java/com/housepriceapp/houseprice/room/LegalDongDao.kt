package com.housepriceapp.houseprice.room

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import io.reactivex.Completable
import io.reactivex.Flowable

@Dao
interface LegalDongDao {
    @Query("SELECT * FROM legalDongCode")
    fun getAll() : Flowable<List<LegalDongCode>>

    @Insert (onConflict = OnConflictStrategy.REPLACE)
    fun insert(legalCode : LegalDongCode) : Completable
}