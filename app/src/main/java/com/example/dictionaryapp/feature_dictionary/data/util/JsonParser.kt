package com.example.dictionaryapp.feature_dictionary.data.util

import java.lang.reflect.Type
interface JsonParser {
    fun <T> fromJson(json: String, type: Type): T?

    fun <T> toJson(obj: T, type: Type): String?



}

// Note :
// This interface contains two functions to get an object from a json string
// and to parse an object to a json string it's a function that will be a generic function

// Q: Why make this interface ? why don't just create the type converter and use gson instance
// in there to manually parse these strings from it to json?
// A: well it could happen that at some point in project we decide that we want to use different
// library to parse json's string,

// and right now we are using gson here but there are so many json parsing libraries there is 'moshi'
// there is kotlin serialization and many more.
// so if we want to switch that then we need to change every single spot in the code where we use that
// dependency so where you use gson/moshi etc.

// However if we use an interface and everywhere in your code you just use that interface then that's
// not necessary bcz then only what we need to change is the implementation of that interface in which
// we tell code hey this is how you use moshi to convert something from into json/this is how you use
// gson to do that