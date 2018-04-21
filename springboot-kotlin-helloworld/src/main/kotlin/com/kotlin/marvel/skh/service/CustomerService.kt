package com.kotlin.marvel.skh.service

import com.kotlin.marvel.skh.model.Customer

interface CustomerService {

    /**
     * 返回 customer 集合
     *
     * @return 返回值是一个用户list 集合
     */
    fun list(): List<Customer>?

}