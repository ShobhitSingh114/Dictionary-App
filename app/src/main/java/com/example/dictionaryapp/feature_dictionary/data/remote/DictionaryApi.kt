package com.example.dictionaryapp.feature_dictionary.data.remote

import com.example.dictionaryapp.feature_dictionary.data.remote.dto.DictionaryDto
import retrofit2.http.GET
import retrofit2.http.Path

interface DictionaryApi {
    // https://api.dictionaryapi.dev/api/v2/entries/en/bank
    // bank = userWord

    @GET("entries/en/{word}")
    suspend fun searchWord(
        @Path("word") word: String
    ): List<DictionaryDto>
}