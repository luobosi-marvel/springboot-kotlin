package com.kotlin.marvel.skh.service.impl

import com.kotlin.marvel.skh.model.Customer
import com.kotlin.marvel.skh.service.CustomerService
import org.springframework.stereotype.Service

/**
 * @author marvel
 * @description 用户 service
 * @date 2018/4/20
 */
@Service("customerService")
open class CustomerServiceImpl : CustomerService{

    override fun list(): List<Customer>? {
        val customer = Customer()
        customer.firstName = "marvel"
        customer.id = 100000L
        customer.password = "123456"
        return listOf(customer)
    }

}