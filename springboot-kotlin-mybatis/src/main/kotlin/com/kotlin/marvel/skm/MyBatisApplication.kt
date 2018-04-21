package com.kotlin.marvel.skm

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource

@SpringBootApplication
@MapperScan("com.kotlin.marvel.skm.**.dao.mapper")
//@ComponentScan(basePackages = {"com.dfire.validator"})
@ImportResource( "classpath:mapper/**/*.xml")
open class MyBatisApplication

fun main(args: Array<String>) {
    SpringApplication.run(MyBatisApplication::class.java, *args)
}