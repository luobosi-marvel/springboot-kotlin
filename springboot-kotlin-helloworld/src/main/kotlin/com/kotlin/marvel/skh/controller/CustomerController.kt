package com.kotlin.marvel.skh.controller

import com.kotlin.marvel.skh.model.Customer
import com.kotlin.marvel.skh.service.CustomerService
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource

/**
 * @author marvel
 * @description 用户控制器 controller
 * @date 2018/4/20
 */
@RestController
@RequestMapping(value = "/customer")
class CustomerController {

    @Resource
    private lateinit var customerService: CustomerService

    @GetMapping(value = "/hello")
    fun hello(): String? {
        return "hello world!"
    }

    @GetMapping(value = "/list")
    fun list(): List<Customer>? {
        return customerService.list()
    }

}