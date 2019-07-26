package com.edt.myapplication.lessions.lession6


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/4/4
 *     desc   :
 *     modify :
 * </pre>
 */
fun main() {
//    checkPerson()
    sendMyEmail()
}

class Person(val firstName: String, val lastName: String) {
    override fun equals(other: Any?): Boolean {
        val otherPerson = other as? Person ?: return false
        return otherPerson.firstName == firstName && otherPerson.lastName == lastName
    }

    override fun hashCode(): Int = firstName.hashCode() * 37 + lastName.hashCode()
}

fun checkPerson() {
    val p1 = Person("Dmitry", "Jemerov")
    val p2 = Person("Dmitry", "Jemerov")
    println(p1 == p2)
    println(p1.equals(42))
}

fun sendEmail(email : String) {
    println("send email")
}

fun sendMyEmail() {
    var email : String? = "yole@example.com"
    email?.let { sendEmail(it) }
    email = null
    email?.let { sendEmail(it) }
}

class MyService {
    fun performAction(): String = "foo"
}

//延迟初始化属性
//1、延迟化属性用lateinit修饰
//2、延迟话属性都是var,因为需要在构造方法外修改它的值，而val属性会被编译成必须在构造方法中初始化的final字段。
//如果在属性倍初始化之前就访问了它，会得到这个异常“lateinit proerty myService has not been initialized"
class MyTest {
    private lateinit var myService: MyService
}

//isBlank是指判断是否包含空白字符串
//isEmpty是指判断是否包含空字符串
fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("isNullOrBlank")
    }
    if (input.isNullOrEmpty()) {
        println("isNullOrEmpty")
    }
}

