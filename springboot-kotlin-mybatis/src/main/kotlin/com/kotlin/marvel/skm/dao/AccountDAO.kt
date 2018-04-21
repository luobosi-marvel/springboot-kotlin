package com.kotlin.marvel.skm.dao

import com.kotlin.marvel.skm.dao.mapper.AccountMapper
import com.kotlin.marvel.skm.model.Account
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Repository
import javax.annotation.Resource

@Repository
class AccountDAO {

    @Resource
    private lateinit var accountMapper: AccountMapper

    /**
     * 列表
     */
    fun list(): List<Account>? {
        return this.accountMapper.list()
    }

    /**
     * 详情
     */
    fun detail(@Param("username") username: String): Account? {
        return this.accountMapper.detail(username)
    }

    /**
     * 删除
     */
    fun delete(@Param("username") username: String) {
        return this.accountMapper.delete(username)
    }
}