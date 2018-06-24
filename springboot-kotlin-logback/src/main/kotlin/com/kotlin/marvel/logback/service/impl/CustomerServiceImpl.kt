package com.kotlin.marvel.logback.service.impl

import com.kotlin.marvel.logback.model.Customer
import com.kotlin.marvel.logback.service.CustomerService
import org.springframework.stereotype.Service

@Service("customerService")
class CustomerServiceImpl: CustomerService {

    /**
     * 获取用户列表
     * 将用户信息打印出来
     */
    override fun list(customer: Customer): List<Customer>? {
        // 打印日志

        return listOf(customer)
    }
}