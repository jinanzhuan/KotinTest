package com.edt.myapplication.domain.commands

interface Command<out T> {
    suspend fun execute(): T
}