package com.kotlin.marvel.logback

import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication

/**
 * @author marvel
 * @description 启动类必须指定为 open 类，不然运行不起来
 * @date 2018/6/20
 */
@SpringBootApplication
open class LogbackApplication

fun main(args: Array<String>) {
    SpringApplication.run(LogbackApplication::class.java, *args)
}