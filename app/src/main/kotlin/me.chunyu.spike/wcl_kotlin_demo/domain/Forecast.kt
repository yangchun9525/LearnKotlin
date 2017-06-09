package me.chunyu.spike.wcl_kotlin_demo.domain

/**
 * Created by chun.yang on 2017/6/8.
 */
data class Forecast(val date: String, val description: String, val high: Int,
                    val low: Int, val iconUrl: String)