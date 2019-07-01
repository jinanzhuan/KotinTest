package com.edt.myapplication.lession4

import java.io.Serializable


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

/**
 * kotlin需要把基类的名字放在尖括号中：super<Clickable>.showoff
 */
class Button: Clickable, Focusable {
    override fun click() {}
    override fun showOff() {
        super<Clickable>.showOff()
        super<Focusable>.showOff()
    }
//    如果只需要实现一个继承的实现，可以如下写法
//    override fun showOff() = super<Clickable>.showOff()
}

fun main(args: Array<String>) {
    val button= Button()
    button.click()
    button.showOff()
    button.setFocus(true)
}

//=================================open,final和abstract修饰符================================
/**
 * kotlin中不论类和方法，默认都是final的，除了以下几种情况：
 * 1、接口默认是open的，集成接口的方法默认也是open的，override修饰的方法默认都是open的
 * 2、抽象类默认是open的，重写的方法默认也是open的, 被abstract修饰的方法必须被子类实现，因而也是open的
 */
open class RichButton: Clickable {  //这个类是open的，其他类可以继承它
    /**
     * 这个函数是final的，不能在子类中重写
     */
    fun disable() {}

    /**
     * 这个函数是open的，可以在子类中重写它
     */
    open fun animate(){}

    /**
     * override修饰的函数本身是open的，可以被子类重写
     */
    override fun click() {
        //
    }

    /**
     * 如果要阻止子类重写，可以显式的将重写的成员标注为final
     */
    final override fun showOff() {
        super.showOff()
    }

}

/**
 * 抽象成员始终是open的，可以不用显式的使用open修饰
 */
abstract class Animated {
    abstract fun animate()
    /**
     * 非抽象函数不是默认open的，如果想要被子类继承重写，可以显示的标注为open
     */
    open fun stopAnimating() {}
    fun animateTwice(){}
}

//=====================================可见性修饰符：public、internal、protected、private==============================
/**
 * 1、如果省略了修饰符，声明就是public
 * 2、在kotlin中,protected成员只能在类和它的子类中可见
 * 3、类的扩展函数不能访问它的private和protected成员
 * 4、Kotlin中一个外部类不能看到其内部（嵌套）类中的private成员
 */
internal open class TalkativeButton: Focusable {
    private fun yell() = println("Hey!")
    protected fun whisper() = println("Let's talk!")
}

//===================================kotlin默认是嵌套类==============================================

//内部类会隐式的持有它的外部类的一个引用。将一个嵌套类声明为static会从这个勒种删除包围它的类的隐式引用


interface State: Serializable

interface View {
    fun getCurrentState(): State
    fun restoreState(state: State) {}
}

/**
 * kotlin中没有显式修饰符的嵌套类与java中的static嵌套类是一样的
 */
class SubButton: View {
    override fun getCurrentState(): State = ButtonState()

    override fun restoreState(state: State) {
        super.restoreState(state)
    }

    class ButtonState: State {}

}