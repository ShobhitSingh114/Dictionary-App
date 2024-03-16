package com.example.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.Dictionary

@Entity
data class DictionaryEntity(
    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val phonetic: String,
    val sourceUrl: List<String>,
    val meanings: List<Meaning>
) {
    fun toDictionary(): Dictionary {
        return Dictionary(
            meanings = meanings,
            phonetic = phonetic,
            sourceUrls = sourceUrl,
            word = word
        )
    }
}
