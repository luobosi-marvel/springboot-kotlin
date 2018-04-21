package com.kotlin.marvel.skm.controller

import com.kotlin.marvel.skm.model.AccountDO
import com.kotlin.marvel.skm.service.IAccountService
import org.springframework.web.bind.annotation.*
import javax.annotation.Resource

/**
 * @author marvel
 * @description 用户控制器，controller 都要标识成 open 类型
 * @date 2018/4/21
 * @since 1.0
 */
@RestController
@RequestMapping(value = "/account")
open class AccountController {

    @Resource
    private lateinit var accountService: IAccountService

    /**
     * 保存一个用户信息
     */
    @PostMapping(value = "/save")
    open fun save(@RequestBody account: AccountDO): AccountDO? {
        this.accountService.save(account)
        return account
    }

    /**
     * 获取所有的用户信息
     */
    @GetMapping(value = "/list")
    open fun list(): List<AccountDO>? {
        return this.accountService.list()
    }

    /**
     * 获取某个用户的详细信息
     */
    @GetMapping(value = "/detail/{username}")
    open fun detail(@PathVariable(value = "username") username: String): AccountDO? {
        return this.accountService.detail(username)
    }

    /**
     * 获取某个用户的详细信息
     */
    @GetMapping(value = "/delete/{username}")
    open fun delete(@PathVariable(value = "username") username: String) {
        this.accountService.delete(username)
    }
}