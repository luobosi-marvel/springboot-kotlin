package com.kotlin.marvel.ske.service

import com.kotlin.marvel.ske.model.Product
import com.kotlin.marvel.ske.repository.ProductRepository
import org.springframework.stereotype.Service
import javax.annotation.Resource


@Service
class IProductService {

    @Resource
    private lateinit var productRepository: ProductRepository

    /**
     * 保存一个产品信息
     */
    fun saveProduct(product: Product): Long? {
        var pro = this.productRepository.save(product)
        return pro.id
    }

    /**
     * 根据描述和分值查找产品信息
     * 使用 and 查询
     *
     * @param description 描述信息
     * @param score       分值
     * @return list
     */
    fun findByDescriptionAndScore(description: String, score: Int): List<Product>? {
        return  this.productRepository.findByDescriptionAndScore(description, score)
    }

    /**
     * 根据描述和分值查找产品信息
     * 使用 or 查询
     *
     * @param description 描述信息
     * @param score       分值
     * @return list
     */
    fun findByDescriptionOrScore(description: String, score: Int): List<Product>? {
        return this.productRepository.findByDescriptionOrScore(description, score)
    }
}