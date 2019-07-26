package com.edt.myapplication.domain.commands

interface Command<out T> {
    fun excude()
}