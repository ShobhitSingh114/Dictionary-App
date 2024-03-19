package com.example.dictionaryapp.feature_dictionary.data.local

import androidx.room.ProvidedTypeConverter
import androidx.room.TypeConverter
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.Meaning
import com.example.dictionaryapp.feature_dictionary.data.util.JsonParser
import com.google.gson.reflect.TypeToken
@ProvidedTypeConverter
class Converters(
    private val jsonParser: JsonParser
) {
    // convert something from meaning list to a json
    // fromMeaningsList -> Json
    @TypeConverter
    fun fromMeaningsJson(json: String): List<Meaning> {
        return jsonParser.fromJson<ArrayList<Meaning>>(
            json,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: emptyList()
    }

    // take a json string and convert it back to meanings list
    // Json -> toMeaningsList
    @TypeConverter
    fun toMeaningsJson(meanings: List<Meaning>): String {
        return jsonParser.toJson(
            meanings,
            object : TypeToken<ArrayList<Meaning>>(){}.type
        ) ?: "[]"
    }

    @TypeConverter
    fun fromStringsJson(json: String): List<String> {
        return jsonParser.fromJson<ArrayList<String>>(
            json,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: emptyList()
    }

    @TypeConverter
    fun toStringsJson(strings: List<String>): String {
        return jsonParser.toJson(
            strings,
            object : TypeToken<ArrayList<String>>(){}.type
        ) ?: "[]"
    }

}

// Note :
// Here we don't specify is that a gson parser, is that a moshi parser
// bcz we don't care this class really only needs to pass something from it to json
// it doesn't care which library is used for that