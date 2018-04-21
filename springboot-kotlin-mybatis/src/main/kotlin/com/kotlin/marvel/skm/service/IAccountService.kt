package com.kotlin.marvel.skm.service

import com.kotlin.marvel.skm.dao.AccountDAO
import com.kotlin.marvel.skm.model.AccountDO
import org.apache.ibatis.annotations.Param
import org.springframework.stereotype.Service
import javax.annotation.Resource

/**
 * @author marvel
 * @description 用户服务类
 * @date 2018/4/21
 * @since 1.0
 */
@Service
class IAccountService {

    @Resource
    private lateinit var accountDAO: AccountDAO
    
    /**
     * 列表
     */
    fun list(): List<AccountDO>? {
        return this.accountDAO.list()
    }

    /**
     * 详情
     */
    fun detail(@Param("username") username: String): AccountDO? {
        return this.accountDAO.detail(username)
    }

    /**
     * 删除
     */
    fun delete(@Param("username") username: String) {
        return this.accountDAO.delete(username)
    }

    fun save(account: AccountDO) {
        this.accountDAO.insert(account)
    }
}