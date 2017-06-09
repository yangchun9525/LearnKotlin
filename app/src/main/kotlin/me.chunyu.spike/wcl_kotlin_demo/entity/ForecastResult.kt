package me.chunyu.spike.wcl_kotlin_demo.entity

import me.chunyu.spike.wcl_kotlin_demo.entity.City
import me.chunyu.spike.wcl_kotlin_demo.entity.Forecast

/**
 * Created by chun.yang on 2017/6/7.
 */
data  class ForecastResult(val city: City, val list: List<Forecast>)