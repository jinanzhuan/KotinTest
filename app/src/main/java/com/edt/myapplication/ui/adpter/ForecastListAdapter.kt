package com.edt.myapplication.ui.adpter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.edt.myapplication.R
import com.edt.myapplication.domain.model.Forecast
import com.edt.myapplication.domain.model.ForecastList
import com.edt.myapplication.extensions.ctx
import com.edt.myapplication.extensions.toDataString
import com.squareup.picasso.Picasso
import kotlinx.android.extensions.LayoutContainer
import kotlinx.android.synthetic.main.item_forecast.*

class ForecastListAdapter(private val weekForecast: ForecastList,
                          private val itemClick: (Forecast) -> Unit): RecyclerView.Adapter<ForecastListAdapter.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.ctx).inflate(R.layout.item_forecast, parent, false)
        return ViewHolder(view, itemClick)
    }

    override fun getItemCount(): Int {
        return weekForecast.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.findForecast(weekForecast[position])
    }

    class ViewHolder(override val containerView: View, private val itemClick: (Forecast) -> Unit)
        : RecyclerView.ViewHolder(containerView), LayoutContainer {
        fun findForecast(forecast: Forecast) {
            with(forecast) {
                Picasso.with(containerView.ctx).load(forecast.iconUrl).into(icon)
                dateText.text = date.toDataString()
                descriptionText.text = description
                maxTemperature.text = "${high}°"
                minTemperature.text = "${low}°"
                itemView.setOnClickListener { itemClick(this) }

            }
        }
    }
}