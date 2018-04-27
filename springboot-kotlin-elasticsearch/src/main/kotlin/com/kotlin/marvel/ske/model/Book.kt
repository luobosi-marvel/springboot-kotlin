package com.kotlin.marvel.ske.model

import io.searchbox.annotations.JestId
import java.util.*

data class Book constructor (
        @JestId
        val id: Long,
        val title: String,
        val authors: List<String>,
        val summary: String,
        val publisher: String,
        val publishDate: Date,
        val numReviews: Int
)