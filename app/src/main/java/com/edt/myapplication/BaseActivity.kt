package com.edt.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/3/26
 *     desc   :
 *     modify :
 * </pre>
 */
abstract class BaseActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(getLayoutId())
        initView()
        initListener()
        initData()
    }

    open fun initView() {
        //
    }

    open fun initListener() {
        //
    }

    open fun initData() {
        //
    }

    abstract fun getLayoutId(): Int

}