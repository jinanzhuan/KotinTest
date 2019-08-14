package com.edt.myapplication.ui.activity

import android.support.v7.widget.Toolbar
import android.widget.TextView
import com.edt.myapplication.BaseActivity
import com.edt.myapplication.R
import com.edt.myapplication.domain.commands.RequestDayForecastCommand
import com.edt.myapplication.domain.model.Forecast
import com.edt.myapplication.extensions.color
import com.edt.myapplication.extensions.textcolor
import com.edt.myapplication.extensions.toDataString
import com.edt.myapplication.ui.ToolbarManager
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.activity_detail.*
import kotlinx.coroutines.launch
import org.jetbrains.anko.find
import java.text.DateFormat

class DetailActivity: BaseActivity(), ToolbarManager {
    override val toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    companion object {
        const val ID = "DetailActivity:id"
        const val CITY_NAME = "DetailActivity:cityName"
    }
    override fun getLayoutId(): Int {
        return R.layout.activity_detail
    }

    override fun initView() {
        super.initView()
        initToolbar()
        toolbarTitle = intent.getStringExtra(CITY_NAME)

        enableHomeAsUp { onBackPressed() }

        launch {
            val id = intent.getLongExtra(ID, -1)
            val result = RequestDayForecastCommand(id).execute()
            bindForecast(result)
        }
    }

    private fun bindForecast(result: Forecast) = with(result) {
        Picasso.with(this@DetailActivity).load(iconUrl).into(icon)
        toolbar.subtitle = date.toDataString(DateFormat.FULL)
        weatherDescription.text = description
        bindWeather(high to maxTemperature, low to minTemperature)
    }

    private fun bindWeather(vararg views: Pair<Int, TextView>) = views.forEach {
        it.second.text = "${it.first}"
        it.second.textcolor = color(when(it.first) {
            in -50..0 -> android.R.color.holo_red_dark
            in 0..15 -> android.R.color.holo_orange_dark
            else -> android.R.color.holo_green_dark
        })
    }
}