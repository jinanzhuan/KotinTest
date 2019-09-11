package com.edt.myapplication.lessions.lession8

import android.app.Activity
import android.content.Context
import android.os.Bundle
import android.widget.RadioButton
import android.widget.RadioGroup

enum class Delivery {STANDARD, EXPEDITED}

class Order(val itemCount: Int)

fun getShippingCostCalculator(
    delivery: Delivery): (Order) -> Double {
        if (delivery == Delivery.EXPEDITED) {
            return {order -> 6 + 2.1 * order.itemCount }
        }
        return {order -> 1.2 * order.itemCount }
    }

fun main(args: Array<String>) {
    val calculator = getShippingCostCalculator(Delivery.EXPEDITED)
    println("Shipping costs ${calculator(Order(3))}")


}

class MyView(context: Context): RadioGroup(context) {
    var listener: (String) -> Unit = {}

    private fun initView(context: Context) {
        setOnCheckedChangeListener { group, checkedId -> listener(group.findViewById<RadioButton>(checkedId).text.toString()) }
    }

    fun setOnLabelCheckedListener(e: (String)->Unit) {
        this.listener = e
    }
}

class MyActivity: Activity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        MyView(this).setOnLabelCheckedListener {  }
    }
}

fun <T, R> Collection<T>.fold(initial: R, combine:(acc: R, nextElement: T)->R): R {
    var accumulator: R = initial
    for (element: T in this) {
        accumulator = combine(accumulator, element)
    }
    return accumulator
}