package com.edt.myapplication

import android.os.Bundle
import com.edt.myapplication.lession5.Person
import com.edt.myapplication.lession5.getSumData

class MainActivity : BaseActivity() {
    override fun getLayoutId(): Int {
        TODO("not implemented") //To change body of created functions use File | Settings | File Templates.
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        initView()
        initListener()
        initData()
    }

    private fun initData() {

    }

    private fun initListener() {

    }

    private fun initView() {
        val people = listOf(Person("Alice", 29), Person("Bob", 31))
//        println(people.maxBy { it.age })
//        println(people.maxBy(Person::age))
//        findTheOldest(listOf(Person("Alice", 29), Person("Bob", 31)))
        getSumData(5, 8)
    }

    private fun printMessageWithPrefix(messages: Collection<String>, prefix: String) {
        messages.forEach {
            println("$prefix $it")
        }
    }
}
