package com.example.dictionaryapp.feature_dictionary.data.remote

import com.example.dictionaryapp.feature_dictionary.data.remote.dto.WordInfoDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    // https://api.dictionaryapi.dev/api/v2/entries/en/bank
    // bank = userWord

    @GET("entries/en/{word}")
    suspend fun getWordInfo(
        @Path("word") word: String
    ): List<WordInfoDto>
    companion object {
        const val BASE_URL = "https://api.dictionaryapi.dev/"
    }
}