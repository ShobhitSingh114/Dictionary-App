package com.example.dictionaryapp.feature_dictionary.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.dictionaryapp.feature_dictionary.data.remote.dto.Meaning
import com.example.dictionaryapp.feature_dictionary.domain.model.WordInfo

@Entity
data class WordInfoEntity(
    @PrimaryKey
    val id: Int? = null,
    val word: String,
    val phonetic: String,
    // we can't store lists in room databse
    val sourceUrl: List<String>,
//    val sourceUrl: String,
    val meanings: List<Meaning>
) {
    fun toWordInfo(): WordInfo {
        return WordInfo(
            meanings = meanings,
            phonetic = phonetic,
            sourceUrls = sourceUrl,
            word = word
        )
    }
}

// Imp-Note :
// There is an issue with this class, bcz right now we try to save a list of meanings in our database but
// room has no idea how we can actually do that bcz we can't naturally save lists in a room database and
// especially not lists of a complex data type like meaning.

// So what To-do Now ?

// (Preferred)[used]
// We will directly save the list of meanings in a entity(DictionaryEntity) by simply parsing it to a
// type that room understands and that is simple a string so we will take this list[Meaning] convert it to
// json string in the end and save it here in our database.
// For that we create something called a type converter in room so that if there is a type in room that
// is not understandable for it then we can define how we can actually transform that to a type that room actually
// understands.
// For this json parsing


// (Not-Preferred)[not used]
// well usually if you want to save a list in an sql database that is a sign that you should put the
// objects that are actually in that list in a separate table here bcz that's what relational database
// are actually perfect for but that's a little complex so for simplicity we didn't do that.