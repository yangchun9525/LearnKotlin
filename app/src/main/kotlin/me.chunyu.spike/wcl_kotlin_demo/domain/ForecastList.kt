package me.chunyu.spike.wcl_kotlin_demo.domain

/**
 * Created by chun.yang on 2017/6/8.
 */
data class ForecastList(val city: String, val country: String,
                        val dailyForecast:List<Forecast>)
