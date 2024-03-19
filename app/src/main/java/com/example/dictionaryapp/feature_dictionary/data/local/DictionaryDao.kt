package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity

@Dao
interface DictionaryDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertWordInfos(infos: List<WordInfoEntity>)

    // we pass a list of words and we will delete that list of words
    // list of words = is that list which we pass

    // delete form the table where the 'word' is in the given list of words
    @Query("DELETE FROM WordInfoEntity WHERE word IN(:words)")
    suspend fun deleteWordInfos(words: List<String>)

    // load from cache

    // LIKE: It's an SQL operator used to match a string
    // ||: It's the concatenation operator in SQL
    // % :word %': This is the pattern being matched against

    // % :word %' = This allows for a flexible search where any word containing
    //              the value of :word as a substring will be returned.
    @Query("SELECT * FROM WordInfoEntity WHERE word LIKE '%' || :word || '%'")
    suspend fun getWordInfos(word: String): List<WordInfoEntity>
}