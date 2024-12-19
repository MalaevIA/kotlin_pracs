package com.example.pr5.data

import androidx.room.Database
import androidx.room.RoomDatabase

@Database(entities = [ProductEntity::class], version = 2, exportSchema = false)
abstract class AppDatabase : RoomDatabase() {
    abstract fun productDao(): ProductDao
}
