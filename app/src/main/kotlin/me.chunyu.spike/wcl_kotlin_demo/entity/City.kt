package me.chunyu.spike.wcl_kotlin_demo.entity

/**
 * Created by chun.yang on 2017/6/7.
 */
data class City(val id: Long, val name: String, val coord: Coordinates,
                val country: String, val population: Int)