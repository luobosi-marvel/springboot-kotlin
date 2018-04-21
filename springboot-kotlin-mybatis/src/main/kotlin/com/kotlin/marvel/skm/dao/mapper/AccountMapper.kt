package com.kotlin.marvel.skm.dao.mapper

import com.kotlin.marvel.skm.model.Account
import org.apache.ibatis.annotations.Mapper
import org.apache.ibatis.annotations.Param

@Mapper
interface AccountMapper {

    /**
     * 列表
     */
    fun list(): List<Account>?

    /**
     * 详情
     */
    fun detail(@Param("username") username: String): Account?

    /**
     * 删除
     */
    fun delete(@Param("username") username: String)
}