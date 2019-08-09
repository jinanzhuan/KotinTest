package com.edt.myapplication

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.Job
import kotlin.coroutines.CoroutineContext


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/3/26
 *     desc   :
 *     modify :
 * </pre>
 */
abstract class BaseActivity : AppCompatActivity(), CoroutineScope {
    lateinit var job: Job
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        job = Job()
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

    override fun onDestroy() {
        job.cancel()
        super.onDestroy()
    }

    override val coroutineContext: CoroutineContext
        get() = Dispatchers.Main + job
}