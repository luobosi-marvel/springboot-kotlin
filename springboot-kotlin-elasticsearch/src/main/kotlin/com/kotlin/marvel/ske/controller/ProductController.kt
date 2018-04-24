package com.kotlin.marvel.ske.controller

import com.kotlin.marvel.ske.model.Product
import com.kotlin.marvel.ske.service.IProductService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

@RestController
@RequestMapping(value = "/product")
open class ProductController {

    @Resource
    private lateinit var productService: IProductService

    /**
     * 保存一个产品信息
     */
    @PostMapping(value = "/save")
    open fun saveProduct(@RequestBody product: Product): Long? {
        return this.productService.saveProduct(product)
    }

    /**
     * 保存一个产品信息
     */
    @PostMapping(value = "/insert")
    open fun insertProduct(@RequestParam(value = "id") id: Long,
                           @RequestParam(value = "productName") productName: String,
                           @RequestParam(value = "description") description: String,
                           @RequestParam(value = "score") score: Int): Product? {
        val product = Product(id, productName, description, score)
        this.productService.saveProduct(product)

        return product
    }
}