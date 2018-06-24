package com.kotlin.marvel.logback.controller

import com.kotlin.marvel.logback.service.CustomerService
import org.slf4j.LoggerFactory
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import javax.annotation.Resource


@RestController
@RequestMapping("/customer")
open class CustomerController {

    @Resource
    private lateinit var customerService: CustomerService

    /**
     * 引入日志，注意都是"org.slf4j"包下
     */
    private val logger = LoggerFactory.getLogger("CustomerController")

    @GetMapping("/print_log/{customerId}")
    open fun printLog(@PathVariable("customerId") customerId: String): String? {
        logger.info("访问 print_log/{customerId}接口，customerId = " + customerId)
        print(customerService)
        return "打印日志"
    }

}