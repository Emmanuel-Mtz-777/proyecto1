package com.example.myapplication1.data.model.database

import androidx.room.Database
import androidx.room.RoomDatabase

import com.example.myapplication1.data.model.dao.ServiceDao
import com.example.myapplication1.data.model.model.ServiceEntity


@Database(entities = [ServiceEntity::class], version = 1)
abstract class AppDatabase: RoomDatabase() {
    abstract fun serviceDao(): ServiceDao

}
