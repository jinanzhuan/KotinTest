package com.edt.myapplication

import android.support.v7.widget.Toolbar
import com.edt.myapplication.extensions.ctx
import org.jetbrains.anko.startActivity
import org.jetbrains.anko.toast

interface ToolbarManager {
    val toolbar: Toolbar

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
}
