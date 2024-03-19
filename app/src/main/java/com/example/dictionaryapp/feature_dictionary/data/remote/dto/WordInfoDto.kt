package com.example.dictionaryapp.feature_dictionary.data.remote.dto

import com.example.dictionaryapp.feature_dictionary.data.local.entity.WordInfoEntity
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

data class WordInfoDto(
    val license: License,
    val meanings: List<Meaning>,
    val phonetic: String,
    val phonetics: List<Phonetic>,
    val sourceUrls: List<String>,
    val word: String
) {
//    fun toWordInfoEntity(): WordInfo {
//        return WordInfo(
//            meanings = meanings,
//            phonetic = phonetic,
//            sourceUrls = sourceUrls,
//            word = word
//        )
//    }
fun toWordInfoEntity(): WordInfoEntity {
    return WordInfoEntity(
        meanings = meanings,
        phonetic = phonetic,
        sourceUrl = sourceUrls,
        word = word
    )
}
}