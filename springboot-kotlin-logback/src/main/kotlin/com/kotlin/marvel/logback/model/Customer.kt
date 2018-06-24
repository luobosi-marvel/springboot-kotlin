package com.kotlin.marvel.logback.model

import java.io.Serializable

/**
 * @author marvel
 * @description 用户实体类
 * @date 2018/6/20
 */
class Customer :Serializable{
    var id: Long = 0L
    var firstName: String = ""
    var password: String = ""
}