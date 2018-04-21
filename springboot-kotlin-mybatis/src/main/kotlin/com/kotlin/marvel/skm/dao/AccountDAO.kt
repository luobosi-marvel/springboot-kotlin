package com.kotlin.marvel.skm.dao

import com.kotlin.marvel.skm.dao.mapper.AccountMapper
import com.kotlin.marvel.skm.model.AccountDO
import org.springframework.stereotype.Component
import javax.annotation.Resource

/**
 * @author marvel
 * @description 用户 DAO ，该类一定要标识成 open 类型
 * @date 2018/4/21
 * @since 1.0
 */
@Component
open class AccountDAO {

    @Resource
    lateinit var accountMapper: AccountMapper

    /**
     * 插入一个用户
     */
    fun insert(account: AccountDO): Int? {
        return this.accountMapper.insert(account)
    }

    /**
     * 列表
     */
    fun list(): List<AccountDO>? {
        return this.accountMapper.list()
    }

    /**
     * 详情
     */
    fun detail(username: String): AccountDO? {
        return this.accountMapper.detail(username)
    }

    /**
     * 删除
     */
    fun delete(username: String) {
        return this.accountMapper.delete(username)
    }


}