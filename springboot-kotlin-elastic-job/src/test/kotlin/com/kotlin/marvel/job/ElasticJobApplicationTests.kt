package com.kotlin.marvel.job

import org.junit.After
import org.junit.Before
import org.junit.Test
import org.springframework.boot.test.context.SpringBootTest

/**
 * @author marvel
 * @description 这个是 spring-boot-kotlin 整合的 测试类
 * @date 2018/5/22
 */
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class IntegrationTests {

    @Before
    fun setup() {
        println(">> Setup")
    }

    @Test
    fun `Assert blog page title, content and status code`() {
        println(">> Assert blog page title, content and status code")
    }

    @Test
    fun `Assert article page title, content and status code`() {
        println(">> Assert article page title, content and status code")
    }

    @After
    fun teardown() {
        println(">> Tear down")
    }

}