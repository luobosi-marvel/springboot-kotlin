package com.kotlin.marvel.skm.model


/**
 * @author marvel
 * @description 用户实体类
 * @date 2018/4/21
 * @since 1.0
 */
data class Account constructor(val id: Long, val username: String, val password: String, val mailbox: String, val realName: String) {}
