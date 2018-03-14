package com.zhongwenhui.tdin360.kotlindemo01

import java.text.DecimalFormat
import java.text.SimpleDateFormat
import java.util.*

/**
 * Created by jeffery on 2018/3/8.
 */
class Utils{
    private val decimalFormat = DecimalFormat("######0.00")
    private val sdf = SimpleDateFormat("yyyyMMddHHmmss")
    private val sdf2 = SimpleDateFormat("yyyy-MM-dd HH:mm:ss")
    /**
     * 订单号

     * @return
     */
    fun OrderNo(): String {
        val date = Date()
        val builder = StringBuilder("gas")
        builder.append(sdf.format(date))
        return builder.append(buildRandom(3)).toString()
    }

    private fun buildRandom(length: Int): Int {
        var num = 1
        var random = Math.random()
        if (random < 0.1)
            random = random + 0.1
        for (i in 0..length - 1) {
            num = num * 10
        }
        return (random * num).toInt()
    }


    // 当前系统时间
    val date: String
        get() {
            val format = SimpleDateFormat("yyyy-MM-dd")
            val date = Date()
            val dateString = format.format(date)
            return dateString
        }

    fun payType(type: String): String {
        if (type == "scan")
            return "移动支付"
        else if (type == "cash")
            return "现金支付"
        else if (type == "card")
            return "会员支付"
        else if (type == "1")
            return "微信支付"
        else if (type == "2")
            return "支付宝"
        else if (type == "3")
            return "QQ钱包"

        return "UNKNOW"
    }

    /**
     * 元2分

     * @param amount
     * *
     * @return
     */
    fun Yuan2Fen(amount: String): String {
        val f = java.lang.Float.valueOf(amount)!! * 100

        return decimalFormat.format(f.toDouble())
    }

    /**
     * 支付状态

     * @param state
     * *
     * @return
     */
    fun payState(state: String) = when (state) {
        "0" -> "支付中"
        "1" -> "支付成功"
        "2" -> "支付失败"
        "3" -> "已冲正"
        "4" -> "已退款"
        "5" -> "退款"
        else -> "未知"
    }

    fun getPayType(t: String): String =
            when (t) {
                "微信" -> "1"
                "QQ" -> "2"
                else -> "3"
            }

}