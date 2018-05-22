package com.kotlin.marvel.job

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author marvel
 * @description 启动类必须指定为 open 类，不然运行不起来
 * @date 2018/5/22
 */
@SpringBootApplication
open class ElasticJobApplication

fun main(args: Array<String>) {
    SpringApplication.run(ElasticJobApplication::class.java, *args)
}