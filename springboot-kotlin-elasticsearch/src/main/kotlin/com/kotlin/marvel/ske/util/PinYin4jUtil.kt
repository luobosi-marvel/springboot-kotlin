package com.kotlin.marvel.ske.util

import net.sourceforge.pinyin4j.PinyinHelper
import net.sourceforge.pinyin4j.format.HanyuPinyinCaseType
import net.sourceforge.pinyin4j.format.HanyuPinyinOutputFormat
import net.sourceforge.pinyin4j.format.HanyuPinyinToneType
import net.sourceforge.pinyin4j.format.HanyuPinyinVCharType
import net.sourceforge.pinyin4j.format.exception.BadHanyuPinyinOutputFormatCombination
import java.util.*

class PinYin4jUtil {

    /**
     * 分隔符
     */
    private val SEPERATOR: String = ","

    /**
     * 大写形式
     */
    private val UPPER_CASE: Boolean = false

    /**
     * 音调输出形式
     */
    private val TONE_TYPE: Int = 0

    private val V_CHAR_TYPE = 0

    /**
     * 获取拼音
     */
    private fun getPinYin(chinese: String, upperCase: Boolean, toneType: Int, vCharType: Int, seperator: String): String {
        val pinyinName = StringBuffer()
        val nameChar = chinese.toCharArray()
        val defaultFormat = getOutputFormat(upperCase, toneType, vCharType)
        for (i in nameChar.indices) {
            if (nameChar[i].toInt() > 128) {
                try {
                    // 取得当前汉字的所有全拼
                    val strs = PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)
                    if (strs != null) {
                        for (j in strs.indices) {
                            pinyinName.append(strs[j])
                            if (j != strs.size - 1) {
                                pinyinName.append(seperator)
                            }
                        }
                    }
                } catch (e: BadHanyuPinyinOutputFormatCombination) {
                    e.printStackTrace()
                }

            } else {
                pinyinName.append(nameChar[i])
            }
            pinyinName.append(" ")
        }
        return parseTheChineseByObject(discountTheChinese(pinyinName.toString(), seperator), seperator)
    }


    /**
     * 汉字转拼音(全拼)
     *
     * @param chinese   汉字
     * @param upperCase 是否转成大写
     * @param toneType  是否输出声调
     * @param vCharType u字母输出类型
     * @return
     */
    fun getPinYin(chinese: String, upperCase: Boolean,
                  toneType: Int, vCharType: Int): String {
        return getPinYin(chinese, upperCase, toneType, vCharType, SEPERATOR)
    }

    /**
     * 汉字转拼音(全拼)
     *
     * @param chinese   汉字
     * @param upperCase 是否转成大写
     * @param toneType  是否输出声调
     * @return
     */
    fun getPinYin(chinese: String, upperCase: Boolean,
                  toneType: Int): String {
        return getPinYin(chinese, upperCase, toneType, V_CHAR_TYPE, SEPERATOR)
    }

    /**
     * 汉字转拼音(全拼)
     *
     * @param chinese   汉字
     * @param upperCase 是否转成大写
     * @return
     */
    fun getPinYin(chinese: String, upperCase: Boolean): String {
        return getPinYin(chinese, upperCase, TONE_TYPE, V_CHAR_TYPE, SEPERATOR)
    }

    /**
     * 汉字转拼音(全拼)
     *
     * @param chinese   汉字
     * @param seperator 分隔符
     * @return
     */
    fun getPinYin(chinese: String, seperator: String): String {
        return getPinYin(chinese, UPPER_CASE, TONE_TYPE, V_CHAR_TYPE, seperator)
    }

    /**
     * 汉字转拼音(全拼)
     *
     * @param chinese 汉字
     * @return
     */
    fun getPinYin(chinese: String): String {
        return getPinYin(chinese, UPPER_CASE, TONE_TYPE, V_CHAR_TYPE, SEPERATOR)
    }

    /**
     * 获取汉字简拼
     *
     * @param chinese   汉字
     * @param upperCase 是否转成大写
     * @param seperator 分隔符
     * @return
     */
    fun getPinYinShort(chinese: String, upperCase: Boolean, seperator: String): String {
        val pinyinName = StringBuffer()
        val nameChar = chinese.toCharArray()
        val defaultFormat = getOutputFormat(upperCase)
        try {
            for (i in nameChar.indices) {
                if (nameChar[i].toInt() > 128) {
                    // 取得当前汉字的所有全拼
                    val strs = PinyinHelper.toHanyuPinyinStringArray(
                            nameChar[i], defaultFormat)
                    if (strs != null) {
                        for (j in strs.indices) {
                            // 取首字母
                            pinyinName.append(strs[j][0])
                            if (j != strs.size - 1) {
                                pinyinName.append(seperator)
                            }
                        }
                    }
                } else {
                    pinyinName.append(nameChar[i])
                }
                pinyinName.append(" ")
            }
        } catch (e: BadHanyuPinyinOutputFormatCombination) {
            e.printStackTrace()
        }

        return parseTheChineseByObject(discountTheChinese(pinyinName.toString(), seperator), seperator)
    }

    /**
     * 获取汉字简拼
     *
     * @param chinese   全拼拼音
     * @param upperCase 是否转成大写
     * @return
     */
    fun getPinYinShort(chinese: String, upperCase: Boolean): String {
        return getPinYinShort(chinese, upperCase, SEPERATOR)
    }

    /**
     * 获取汉字简拼
     *
     * @param chinese 全拼拼音
     * @return
     */
    fun getPinYinShort(chinese: String): String {
        return getPinYinShort(chinese, UPPER_CASE, SEPERATOR)
    }

    /**
     * 获取汉字全拼
     *
     * @param chinese
     * @param upperCase
     * @param toneType
     * @param vCharType
     * @return
     */
    private fun getPinYinCollection(chinese: String, upperCase: Boolean,
                            toneType: Int, vCharType: Int): Collection<String>? {
        val pinyinList = ArrayList<Array<String>>()
        val defaultFormat = getOutputFormat(upperCase, toneType, vCharType)
        try {
            for (i in 0..chinese.length - 1) {
                val pinyinArray = PinyinHelper.toHanyuPinyinStringArray(
                        chinese[i], defaultFormat)
                if (pinyinArray != null && pinyinArray.isNotEmpty()) {
                    pinyinList.add(pinyinArray)
                }
            }
        } catch (e: BadHanyuPinyinOutputFormatCombination) {
            e.printStackTrace()
        }

        var pinyins: MutableSet<String>? = null
        for (array in pinyinList) {
            if (pinyins == null || pinyins.isEmpty()) {
                pinyins = HashSet()
                for (charPinpin in array) {
                    pinyins.add(charPinpin)
                }
            } else {
                val pres = pinyins
                pinyins = HashSet()
                for (pre in pres) {
                    for (charPinyin in array) {
                        pinyins.add(pre + charPinyin)
                    }
                }
            }
        }
        return pinyins
    }

    fun getPinYinCollection(chinese: String, upperCase: Boolean,
                            toneType: Int): Collection<String>? {
        return getPinYinCollection(chinese, upperCase, toneType, V_CHAR_TYPE)
    }

    fun getPinYinCollection(chinese: String, upperCase: Boolean): Collection<String>? {
        return getPinYinCollection(chinese, upperCase, TONE_TYPE, V_CHAR_TYPE)
    }

    fun getPinYinCollection(chinese: String): Collection<String>? {
        return getPinYinCollection(chinese, UPPER_CASE, TONE_TYPE, V_CHAR_TYPE)
    }

    private fun getPinYinShortCollection(chinese: String, upperCase: Boolean,
                                 toneType: Int, vCharType: Int): Collection<String> {
        val pinyinList = ArrayList<Array<String>>()
        val defaultFormat = getOutputFormat(upperCase, toneType, vCharType)
        try {
            for (i in 0..chinese.length - 1) {
                val pinyinArray = PinyinHelper.toHanyuPinyinStringArray(
                        chinese[i], defaultFormat)
                if (pinyinArray != null && pinyinArray.isNotEmpty()) {
                    pinyinList.add(pinyinArray)
                }
            }
        } catch (e: BadHanyuPinyinOutputFormatCombination) {
            e.printStackTrace()
        }

        val sorts = HashSet<String>()
        var pinyins: MutableSet<String>? = null
        for (array in pinyinList) {
            if (pinyins == null || pinyins.isEmpty()) {
                pinyins = HashSet()
                for (charPinpin in array) {
                    pinyins.add(charPinpin.substring(0, 1))
                    sorts.add(charPinpin.substring(0, 1))
                }
            } else {
                val pres = pinyins
                pinyins = HashSet()
                for (pre in pres) {
                    for (charPinyin in array) {
                        pinyins.add(pre + charPinyin.substring(0, 1))
                        sorts.add(pre + charPinyin.substring(0, 1))
                    }
                }
            }
        }
        return sorts
    }

    fun getPinYinShortCollection(chinese: String, upperCase: Boolean,
                                 toneType: Int): Collection<String> {
        return getPinYinShortCollection(chinese, upperCase, toneType, V_CHAR_TYPE)
    }

    fun getPinYinShortCollection(chinese: String, upperCase: Boolean): Collection<String> {
        return getPinYinShortCollection(chinese, upperCase, TONE_TYPE, V_CHAR_TYPE)
    }

    fun getPinYinShortCollection(chinese: String): Collection<String> {
        return getPinYinShortCollection(chinese, UPPER_CASE, TONE_TYPE, V_CHAR_TYPE)
    }


    /**
     * Default Format 默认输出格式
     *
     * @return
     */
    fun getOutputFormat(): HanyuPinyinOutputFormat {
        val format = HanyuPinyinOutputFormat()
        format.caseType = HanyuPinyinCaseType.LOWERCASE// 小写
        format.toneType = HanyuPinyinToneType.WITHOUT_TONE// 不显示音调
        format.vCharType = HanyuPinyinVCharType.WITH_V// V显示
        return format
    }

    private fun getOutputFormat(upperCase: Boolean): HanyuPinyinOutputFormat {
        val format = HanyuPinyinOutputFormat()
        format.caseType = if (upperCase)
            HanyuPinyinCaseType.UPPERCASE
        else
            HanyuPinyinCaseType.LOWERCASE
        format.toneType = HanyuPinyinToneType.WITHOUT_TONE// 不显示音调
        format.vCharType = HanyuPinyinVCharType.WITH_V// V显示
        return format
    }

    private fun getOutputFormat(upperCase: Boolean,
                        toneType: Int, vCharType: Int): HanyuPinyinOutputFormat {
        val format = HanyuPinyinOutputFormat()
        format.caseType = if (upperCase)
            HanyuPinyinCaseType.UPPERCASE
        else
            HanyuPinyinCaseType.LOWERCASE
        when (toneType) {
            0 -> format.toneType = HanyuPinyinToneType.WITHOUT_TONE
            1 -> format.toneType = HanyuPinyinToneType.WITH_TONE_MARK
            2 -> format.toneType = HanyuPinyinToneType.WITH_TONE_NUMBER
            else -> format.toneType = HanyuPinyinToneType.WITHOUT_TONE
        }

        when (vCharType) {
            0 -> format.vCharType = HanyuPinyinVCharType.WITH_V
            1 -> format.vCharType = HanyuPinyinVCharType.WITH_U_UNICODE
            2 -> format.vCharType = HanyuPinyinVCharType.WITH_U_AND_COLON
            else -> format.vCharType = HanyuPinyinVCharType.WITH_V
        }
        return format
    }

    /**
     * 判断字符串是否全部由数字组成
     *
     * @param str
     * @return
     */
    fun isNumeric(str: String?): Boolean {
        if (null == str || str.isEmpty()) {
            return false
        }
        var i = str.length
        while (--i >= 0) {
            if (!Character.isDigit(str[i])) {
                return false
            }
        }
        return true
    }

    /**
     * 判断字符串是否全部由数字组成
     *
     * @param str
     * @return
     */
    fun isLetter(str: String?): Boolean {
        if (null == str || str.length == 0) {
            return false
        }
        var i = str.length
        while (--i >= 0) {
            if (!Character.isAlphabetic(str[i].toInt())) {
                return false
            }
        }
        return true
    }

    private fun discountTheChinese(theStr: String, seperator: String): List<Map<String, Int>> {
        // 去除重复拼音后的拼音列表
        val mapList = ArrayList<Map<String, Int>>()
        // 用于处理每个字的多音字，去掉重复
        var onlyOne: MutableMap<String, Int>? = null
        val firsts = theStr.split(" ".toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
        // 读出每个汉字的拼音
        for (str in firsts) {
            onlyOne = Hashtable()
            val china = str.split(seperator.toRegex()).dropLastWhile { it.isEmpty() }.toTypedArray()
            // 多音字处理
            for (s in china) {
                var count: Int? = onlyOne[s]
                if (count == null) {
                    onlyOne.put(s, 1)
                } else {
                    onlyOne.remove(s)
                    count++
                    onlyOne.put(s, count)
                }
            }
            mapList.add(onlyOne)
        }
        return mapList
    }

    /**
     * 解析并组合拼音，对象合并方案
     *
     * @return
     */
    private fun parseTheChineseByObject(list: List<Map<String, Int>>, seperator: String): String {
        // 用于统计每一次,集合组合数据
        var first: MutableMap<String, Int>? = null
        // 遍历每一组集合
        for (i in list.indices) {
            // 每一组集合与上一次组合的Map
            val temp = Hashtable<String, Int>()
            // 第一次循环，first为空
            if (first != null) {
                // 取出上次组合与此次集合的字符，并保存
                for (s in first.keys) {
                    list[i].keys
                            .map { s + it }
                            .forEach { temp.put(it, 1) }
                }
                // 清理上一次组合数据
                if (temp != null && temp.size > 0) {
                    first.clear()
                }
            } else {
                for (s in list[i].keys) {
                    temp.put(s, 1)
                }
            }
            // 保存组合数据以便下次循环使用
            if (temp != null && temp.size > 0) {
                first = temp
            }
        }
        var returnStr = ""
        if (first != null) {
            // 遍历取出组合字符串
            for (str in first.keys) {
                returnStr += str + seperator
            }
        }
        if (returnStr.isNotEmpty()) {
            returnStr = returnStr.substring(0, returnStr.length - 1)
        }
        return returnStr
    }

}

fun main(args: Array<String>) {
    val model = PinYin4jUtil()

    val s = "重庆"
    val pinyin = model.getPinYin(s, ",")
    println(pinyin)
    // 简称
    val abbreviation = model.getPinYinShort(s, true, ",")
    println(abbreviation)

    val collection = model.getPinYinCollection(s)
    if (collection != null) {
        for (str in collection) {
            println(str)
        }
    }
}