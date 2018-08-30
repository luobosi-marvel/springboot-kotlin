package com.kotlin.marvel.skh.demo

import com.kotlin.marvel.skh.service.impl.CustomerServiceImpl


//variables and constants
var currentVersionCode = 1   //变量当前的版本号，类型Int可以根据值推断出来
var currentVersionName : String = "1.0" //显式标明类型
val APPNAME = "droidyue.com" //常量APPNAME 类型(String)可以根据值推断出来

//methods
fun main(args: Array<String>) {
    println(args)
}

// class
class MainActivity : CustomerServiceImpl() {

}

// data class  自动生成getter，setting，hashcode和equals等方法
data class Book(var name: String, val price: Float, var author: String)

