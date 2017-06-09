package me.chunyu.spike.wcl_kotlin_demo.command

import me.chunyu.spike.wcl_kotlin_demo.ForecastRequest
import me.chunyu.spike.wcl_kotlin_demo.domain.Command
import me.chunyu.spike.wcl_kotlin_demo.domain.ForecastDataMapper
import me.chunyu.spike.wcl_kotlin_demo.domain.ForecastList

/**
 * Created by chun.yang on 2017/6/8.
 */
class RequestForecastCommand(val zipCode: String) :
        Command<ForecastList> {
    override fun execute(): ForecastList {
        val forecastRequest = ForecastRequest(zipCode)
        return ForecastDataMapper().convertFromDataModel(
                forecastRequest.execute())
    }
}