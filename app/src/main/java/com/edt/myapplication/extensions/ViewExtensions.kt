package com.edt.myapplication.extensions

import android.content.Context
import android.view.View
import android.widget.TextView

val View.ctx: Context
    get() = context

fun View.slideExit() {
    if (translationY == 0f)animate().translationY(-height.toFloat())
}

fun View.slideEnter() {
    if (translationY < 0f)animate().translationY(0f)
}

var TextView.textcolor: Int
    get() = currentTextColor
    set(value) = setTextColor(value)