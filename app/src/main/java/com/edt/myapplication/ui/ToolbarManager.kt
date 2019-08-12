package com.edt.myapplication.ui

import android.support.v7.graphics.drawable.DrawerArrowDrawable
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.Toolbar
import com.edt.myapplication.App
import com.edt.myapplication.R
import com.edt.myapplication.extensions.ctx
import com.edt.myapplication.extensions.slideEnter
import com.edt.myapplication.extensions.slideExit
import com.edt.myapplication.ui.activity.SettingsActivity
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

interface ToolbarManager {
    val toolbar: Toolbar

    var toolbarTitle: String
        get() = toolbar.title.toString()
        set(value) {
            toolbar.title = value
        }

    fun initToolbar() {
        toolbar.inflateMenu(R.menu.menu_main)
        toolbar.setOnMenuItemClickListener {
            when(it.itemId) {
                R.id.action_setting -> toolbar.ctx.startActivity<SettingsActivity>()
                else -> App.instance.toast("Unknow option")
            }
            true
        }
    }

    fun enableHomeAsUp(up:()->Unit) {
        toolbar.navigationIcon = createUpDrawable()
        toolbar.setNavigationOnClickListener { up() }
    }

    fun createUpDrawable() = DrawerArrowDrawable(toolbar.ctx).apply { progress = 1f }

    fun attachToScroll(recyclerView: RecyclerView) {
        recyclerView.addOnScrollListener(object :RecyclerView.OnScrollListener(){
            override fun onScrolled(recyclerView: RecyclerView, dx: Int, dy: Int) {
                super.onScrolled(recyclerView, dx, dy)
                if (dy > 0) toolbar.slideExit() else toolbar.slideEnter()
            }
        })
    }
}
