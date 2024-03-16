package com.example.dictionaryapp.feature_dictionary.data.remote.dto

import com.example.dictionaryapp.feature_dictionary.domain.model.Dictionary

data class DictionaryDto(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
) {
    fun toDictionary(): Dictionary {
        return Dictionary(
            meanings = meanings,
            phonetic = phonetic,
            sourceUrls = sourceUrls,
            word = word
        )
    }
}