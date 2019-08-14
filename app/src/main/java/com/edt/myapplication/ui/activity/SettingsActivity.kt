package com.edt.myapplication.ui.activity

import android.view.MenuItem
import com.edt.myapplication.BaseActivity
import com.edt.myapplication.R
import com.edt.myapplication.extensions.DelegatesExt
import kotlinx.android.synthetic.main.activity_settings.*
import kotlinx.android.synthetic.main.toolbar.*

class SettingsActivity: BaseActivity() {
    companion object {
        const val ZIP_CODE = "zipcode"
        const val DEFAULT_ZIP = 94043L
    }

    private val zipCode: Long by DelegatesExt.preference(this, ZIP_CODE, DEFAULT_ZIP)

    override fun getLayoutId(): Int {
        return R.layout.activity_settings
    }

    override fun initView() {
        super.initView()
        setSupportActionBar(toolbar)
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        cityCode.setText(zipCode.toString())
    }

    override fun onOptionsItemSelected(item: MenuItem) = when(item.itemId) {
        android.R.id.home -> {
            onBackPressed()
            true
        }
        else -> false
    }
}