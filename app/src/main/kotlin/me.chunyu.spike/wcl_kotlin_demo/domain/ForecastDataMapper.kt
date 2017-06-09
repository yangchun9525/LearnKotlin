package me.chunyu.spike.wcl_kotlin_demo.domain

import me.chunyu.spike.wcl_kotlin_demo.ForecastRequest.Companion.generateIconUrl
import me.chunyu.spike.wcl_kotlin_demo.entity.ForecastResult
import java.text.DateFormat
import java.util.*

/**
 * Created by chun.yang on 2017/6/8.
 */
public class ForecastDataMapper {
    fun convertFromDataModel(forecast: ForecastResult): ForecastList {
        return ForecastList(forecast.city.name, forecast.city.country,
                convertForecastListToDomain(forecast.list))
    }

    fun convertForecastListToDomain(list: List<me.chunyu.spike.wcl_kotlin_demo.entity.Forecast>):
            List<Forecast> {
        return list.map { convertForecastItemToDomain(it) }
    }

    fun convertForecastItemToDomain(forecast: me.chunyu.spike.wcl_kotlin_demo.entity.Forecast): Forecast {
        return Forecast(convertDate(forecast.dt),
                forecast.weather[0].description, forecast.temp.max.toInt(),
                forecast.temp.min.toInt(),  generateIconUrl(forecast.weather[0].icon))
    }

    fun convertDate(date: Long): String {
        val df = DateFormat.getDateInstance(DateFormat.MEDIUM, Locale.getDefault())
        return df.format(date * 1000)
    }

}