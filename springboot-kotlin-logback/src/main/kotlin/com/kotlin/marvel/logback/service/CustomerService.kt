package com.kotlin.marvel.logback.service

import com.kotlin.marvel.logback.model.Customer

/**
 * 用户 Service 接口
 */
interface CustomerService {
    /**
     * 返回 customer 集合
     *
     * @return 返回值是一个用户list 集合
     */
    fun list(customer: Customer): List<Customer>?
}