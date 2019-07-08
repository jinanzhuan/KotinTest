package com.edt.myapplication.lession5

import android.content.Context
import android.content.DialogInterface
import android.util.AttributeSet
import android.view.View
import android.widget.Button

fun alphabet(): String {
    val result = StringBuilder()
    for (letter in 'A'..'Z') {
        result.append(letter)
    }
    result.append("\nNow I know the alphabet!")
    return result.toString()
}

fun alphabet2(): String {
    return with(StringBuilder()){
        for (letter in 'A'..'Z'){
            append(letter)
        }
        append("\nNow I know the alphabet!")
        toString()
    }
}

fun alphabet3():String = with(StringBuilder()){
    for (letter in 'A'..'Z'){
        append(letter)
    }
    append("")
    toString()
}

fun alphabet4():String = StringBuilder().apply {
    for (letter in  'A'..'Z'){
        append(letter)
    }
    append("")
}.toString()

