package com.example.dictionaryapp.feature_dictionary.domain.model

import com.example.dictionaryapp.feature_dictionary.data.remote.dto.License
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.Meaning
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.Phonetic

data class Dictionary(
    val meanings: List<Meaning>,
    val phonetic: String,
    val sourceUrls: List<String>,
    val word: String
)
