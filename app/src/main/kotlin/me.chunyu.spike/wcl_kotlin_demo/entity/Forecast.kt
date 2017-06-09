package me.chunyu.spike.wcl_kotlin_demo.entity

/**
 * Created by chun.yang on 2017/6/7.
 */
data class Forecast(val dt: Long, val temp: Temperature, val pressure: Float,
                    val humidity: Int, val weather: List<Weather>,
                    val speed: Float, val deg: Int, val clouds: Int,
                    val rain: Float)