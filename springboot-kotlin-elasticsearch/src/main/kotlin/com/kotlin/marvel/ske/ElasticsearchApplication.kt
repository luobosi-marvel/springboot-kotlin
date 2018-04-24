package com.kotlin.marvel.ske

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource


/**
 * @author marvel
 * @description 启动类必须指定为 open 类，不然运行不起来
 * @date 2018/4/23
 */
@SpringBootApplication
@ImportResource("classpath:config/*.xml")
open class ElasticsearchApplication

fun main(args: Array<String>) {
    SpringApplication.run(ElasticsearchApplication::class.java, *args)
}
