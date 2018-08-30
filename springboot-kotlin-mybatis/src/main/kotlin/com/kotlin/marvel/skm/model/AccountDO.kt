package com.kotlin.marvel.skm.model


/**
 * @author marvel
 * @description 用户实体类
 * 使用 data 声明一个实体类
 *
 * var： var是一个可变变量，这是一个可以通过重新分配来更改为另一个值的变量。这种声明变量的方式和Java中声明变量的方式一样。
 * val: val是一个只读变量，这种声明变量的方式相当于java中的final变量。一个val创建的时候必须初始化，因为以后不能被改变。
 *
 * @date 2018/4/21
 * @since 1.0
 */
data class AccountDO constructor(
        val id: Long,
        val username: String,
        val mobile: String,
        val password: String,
        val mailbox: String,
        val realName: String)
