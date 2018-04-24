package com.kotlin.marvel.ske.model

import org.springframework.data.elasticsearch.annotations.Document

@Document(indexName = "product", type = "phone")
data class Product constructor(val id: Long, val productName: String, val description: String, val score: Int)