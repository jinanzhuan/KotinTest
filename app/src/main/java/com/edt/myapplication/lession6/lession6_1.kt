package com.edt.myapplication.lession6


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



fun verifyUserInput(input: String?) {
    if (input.isNullOrBlank()) {
        println("Please fill in the required fields")
    }
}
