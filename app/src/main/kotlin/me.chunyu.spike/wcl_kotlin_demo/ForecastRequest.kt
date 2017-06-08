package me.chunyu.spike.wcl_kotlin_demo

import android.util.Log
import com.google.gson.Gson
import java.net.URL

/**
 * Created by chun.yang on 2017/6/7.
 */
public class ForecastRequest(val zipCode:String) {
    //用于存放静态数据
    companion object {
        private val APP_ID = "15646a06818f61f7b8d7823ca833e1ce"
        private val URL = "http://api.openweathermap.org/data/2.5/" +
                "forecast/daily?mode=json&units=metric&cnt=7"
        private val COMPLETE_URL = "$URL&APPID=$APP_ID&q="
    }

    fun execute(): ForecastResult {
        val forecastJsonStr = URL(COMPLETE_URL + zipCode).readText()
        return Gson().fromJson(forecastJsonStr, ForecastResult::class.java)
    }
}