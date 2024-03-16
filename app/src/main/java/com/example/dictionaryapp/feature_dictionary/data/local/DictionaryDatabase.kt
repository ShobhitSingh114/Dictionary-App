package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.dictionaryapp.feature_dictionary.data.local.entity.DictionaryEntity

@Database(entities = [DictionaryEntity::class], version = 1)
abstract class DictionaryDatabase: RoomDatabase() {
    abstract val dictionaryDao: DictionaryDao
}