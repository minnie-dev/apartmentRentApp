package com.housepriceapp.houseprice.room

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase

@Database(entities = [LegalDongCode::class], version = 1)
abstract class LegalDongDB : RoomDatabase() {
    abstract fun legalDongDao(): LegalDongDao

    companion object {
        private var INSTANCE: LegalDongDB? = null
        fun getInstance(context: Context): LegalDongDB? {
            if (INSTANCE == null) {
                synchronized(LegalDongDB::class) {
                    INSTANCE = Room.databaseBuilder(
                        context.applicationContext,
                        LegalDongDB::class.java, "legalDongCode.db")
                        .fallbackToDestructiveMigration()
                        .allowMainThreadQueries() // Todo 추후 비동기로 작업할 때 삭제
                        .build()
                }
            }

            return INSTANCE
        }
    }
}