package com.example.myapplication1.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase


@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase : RoomDatabase() {
    abstract fun ServiceDao(): ServiceDao

}