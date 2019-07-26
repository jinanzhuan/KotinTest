package com.edt.myapplication.lessions.lession6

/**
 * 一般的规则是在代码的任何地方都应该使用只读接口，只在代码需要修改集合的地方使用可变接口的变体
 * 如果用了集合作为组件部状态的一部分，可能需要把集合先拷贝一份再传递给这样的函数（这种模式通常称为防御式拷贝）
 */
fun <T> copyElements(source: Collection<T>, target: MutableCollection<T>) {
    for (item in source) {
        target.add(item)
    }
}

fun main(args: Array<String>) {
    val source = listOf(3, 5, 7)
    val target = arrayListOf(1)
    copyElements(source, target)
    println(target)
}