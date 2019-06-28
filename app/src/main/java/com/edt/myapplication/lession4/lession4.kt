package com.edt.myapplication.lession4


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/6/28
 *     desc   :
 *     modify :
 * </pre>
 */
//Kotlin中的接口

interface Clickable {
    fun click()
    fun showOff() = println("I'm clickable!")
}

interface Focusable {
    fun setFocus(b: Boolean) = println("I ${if (b) "got" else "lost"} focus.")
    fun showOff() = println("I'm focusable!")
}

class Button: Clickable, Focusable {
    override fun click() {}
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
}

fun main(args: Array<String>) {
    val button= Button()
    button.click()
    button.showOff()
    button.setFocus(true)
}