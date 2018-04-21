package com.kotlin.marvel.skm.dao.mapper

import com.kotlin.marvel.skm.model.AccountDO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository


/**
 * @author marvel
 * @description account mapper
 * @date 2018/4/21
 * @since 1.0
 */
@Repository
interface AccountMapper {

    /**
     * 插入一个用户
     */
    fun insert(account: AccountDO): Int?

    /**
     * 列表
     */
    fun list(): List<AccountDO>?

    /**
     * 详情
     */
    fun detail(@Param("username") username: String): AccountDO?

    /**
     * 删除
     */
    fun delete(@Param("username") username: String)


}