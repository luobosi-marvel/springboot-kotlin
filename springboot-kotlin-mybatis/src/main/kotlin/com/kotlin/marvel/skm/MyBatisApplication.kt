package com.kotlin.marvel.skm

import org.mybatis.spring.annotation.MapperScan
import org.springframework.boot.SpringApplication
import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.context.annotation.ImportResource

/**
 * @author marvel
 * @description 启动类，该启动类一定要标识成 open 类型
 * @date 2018/4/21
 * @since 1.0
 */
@SpringBootApplication
@MapperScan("com.kotlin.marvel.skm.dao.mapper")
//@ComponentScan(basePackages = {"com.dfire.validator"})
@ImportResource( "classpath*:mapper/*Mapper.xml")
open class MyBatisApplication

fun main(args: Array<String>) {
    SpringApplication.run(MyBatisApplication::class.java, *args)
}