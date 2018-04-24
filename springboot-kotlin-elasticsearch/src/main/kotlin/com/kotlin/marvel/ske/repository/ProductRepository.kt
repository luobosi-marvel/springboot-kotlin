package com.kotlin.marvel.ske.repository

import com.kotlin.marvel.ske.model.Product
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository
import org.springframework.stereotype.Repository

interface ProductRepository : ElasticsearchRepository<Product, Long> {

    /**
     * 根据描述和分值查找产品信息
     * 使用 and 查询
     *
     * @param description 描述信息
     * @param score       分值
     * @return list
     */
    fun findByDescriptionAndScore(description: String, score: Int): List<Product>?

    /**
     * 根据描述和分值查找产品信息
     * 使用 or 查询
     *
     * @param description 描述信息
     * @param score       分值
     * @return list
     */
    fun findByDescriptionOrScore(description: String, score: Int): List<Product>?


}