package me.chunyu.spike.wcl_kotlin_demo

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import me.chunyu.spike.wcl_kotlin_demo.domain.Forecast
import me.chunyu.spike.wcl_kotlin_demo.domain.ForecastList
import org.jetbrains.anko.find

/**
 * Created by chun.yang on 2017/6/2.
 */
class ForecastListAdapter(val weekForecast: ForecastList,val itemClick: OnItemClickListener) : RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx)
                .inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
//        with(weekForecast.dailyForecast[position]) {
//            holder.textView.text = "$date - $description - $high/$low"
//        }
        holder.bindForecast(weekForecast.dailyForecast[position])
    }

    override fun getItemCount(): Int = weekForecast.dailyForecast.size

//    class ViewHolder(val textView: TextView) : RecyclerView.ViewHolder(textView)
    class ViewHolder(view: View,val itemClick: OnItemClickListener) : RecyclerView.ViewHolder(view){
        private val iconView: ImageView
        private val dateView: TextView
        private val descriptionView: TextView
        private val maxTemperatureView: TextView
        private val minTemperatureView: TextView

        init {
            iconView = view.find(R.id.icon)
            dateView = view.find(R.id.date)
            descriptionView = view.find(R.id.description)
            maxTemperatureView = view.find(R.id.maxTemperature)
            minTemperatureView = view.find(R.id.minTemperature)
        }

        fun bindForecast(forecast: Forecast) {
            with(forecast) {
                Glide.with(itemView.ctx).load(iconUrl).into(iconView)
                dateView.text = date
                descriptionView.text = description
                maxTemperatureView.text = "${high.toString()}"
                minTemperatureView.text = "${low.toString()}"
                itemView.setOnClickListener { itemClick(forecast) }
            }
        }
    }

    public interface OnItemClickListener {
        operator fun invoke(forecast: Forecast)
    }
}
