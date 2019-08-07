package com.edt.myapplication.ui.activity

import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.Toolbar
import com.edt.myapplication.BaseActivity
import com.edt.myapplication.R
import com.edt.myapplication.ui.ToolbarManager
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.find

class MainActivity : BaseActivity(), ToolbarManager {
    override val toolbar: Toolbar by lazy { find<Toolbar>(R.id.toolbar) }

    override fun getLayoutId(): Int {
        return R.layout.activity_main
    }

    override fun initView() {
        super.initView()
        initToolbar()

        forecastList.layoutManager = LinearLayoutManager(this)
        attachToScroll(forecastList)
    }

    override fun initListener() {
        super.initListener()
    }

    override fun initData() {
        super.initData()
    }

    override fun onResume() {
        super.onResume()
        loadForecast()
    }

    private fun loadForecast() {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

}
