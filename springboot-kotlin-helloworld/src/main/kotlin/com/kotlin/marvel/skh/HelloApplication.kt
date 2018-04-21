package com.kotlin.marvel.skh

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author marvel
 * @description 启动类必须指定为 open 类，不然运行不起来
 * @date 2018/4/20
 */
@SpringBootApplication
open class KotlinApplication

fun main(args: Array<String>) {
    SpringApplication.run(KotlinApplication::class.java, *args)
}
 