package com.edt.myapplication.lession4

import android.content.Context
import android.util.AttributeSet


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/7/3
 *     desc   :
 *     modify :
 * </pre>
 */

//============================================构造方法====================================
/**
 * 声明一个简单类
 * 这段被括号围起来的语句块就叫作：主构造方法
 * 有两个目的：表明构造方法的参数，以及定义使用这些参数初始化的属性
 */
open class User(val nickname: String)

/*class User constructor(_nickname: String) {
    val nickname: String

    *//**
 * 初始化语句块，可以声明多个初始化语句块
 *//*
    init {
        nickname = _nickname
    }
}*/

//在上面的例子中，不需要把初始化代码放在初始化语句块汇总，因为它可以与nickname属性的声明结合。
// 如果主构造方法没有注解或可见性修饰符，同样可以去掉constructor关键字

/*
class User(_nickname: String) {
    val nickname = _nickname
}
*/

//如果属性用响应的构造方法参数来初始化，代码可以通过把val关键字加载参数钱的方式来进行简化
//val意味着相应的属性会用构造方法的参数来初始化
/*
class User(val nickname: String)*/
/**
 * 可以像函数参数一样为构造方法声明一个默认值
 */
class User2(val nickname: String, val isSubscribed: Boolean = true)


class TwitterUser(nickname: String): User(nickname) {}

open class MyButton

class RadioButton: MyButton()


class Secretive private constructor() {}


open class MyView {
    constructor(ctx: Context){}
    constructor(ctx: Context, attr: AttributeSet)
}

class MyButtonView: MyView {

    constructor(ctx: Context): super(ctx){}

    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr){}

}
//
//class MyButtonView: MyView {
//    constructor(ctx: Context): this(ctx, null){}
//    constructor(ctx: Context, attr: AttributeSet): super(ctx, attr){}
//}

interface User3 {
    val nickname: String
}

class PrivateUser3(override val nickname: String): User3

class SubscribeingUser3(val email: String): User3 {
    override val nickname: String
        get() = email.substringBefore("@")
}

class FacebookUser3(val accountId: Int): User3 {
    override val nickname: String
        get() = getFacebookName(accountId)

    private fun getFacebookName(accountId: Int): String {
        return ""
    }
}

interface User4 {
    val email: String
    val nickname: String
        get() = email.substringBefore('@')
}


class User5(val name: String) {
    var address: String = "Unspecified"
        set(value) {
            println(
                """Address was changed for $name:
                    "$field" -> "$value".""".trimIndent())
            field = value
        }
}


class LengthCounter {
    var counter: Int = 0
        private set

    fun addWord(word: String) {
        counter += word.length
    }
}

data class Client(val name: String, val postalCode: Int)

class DelegatingCollection<T> : Collection<T> {
    private val innerList = arrayListOf<T>()

    override val size: Int
        get() = innerList.size

    override fun contains(element: T): Boolean = innerList.contains(element)

    override fun containsAll(elements: Collection<T>): Boolean = innerList.containsAll(elements)

    override fun isEmpty(): Boolean = innerList.isEmpty()

    override fun iterator(): Iterator<T> = innerList.iterator()

}

class MyDelegatingCollection<T>(innerList: Collection<T> = arrayListOf()): Collection<T> by innerList