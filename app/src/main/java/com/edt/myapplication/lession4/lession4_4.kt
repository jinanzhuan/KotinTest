package com.edt.myapplication.lession4

import java.io.File

/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/7/3
 *     desc   :
 *     modify :
 * </pre>
 */

fun main(args: Array<String>) {
    Payroll.allEmployees.add(Person("张三"))
    println(Payroll.allEmployees)
    Payroll.allEmployees.add(Person("李四"))
    println(Payroll.allEmployees)
    println(CaseInsensitiveFileComparator.compare(File("/User"), File("/user")))
    A.bar()
}

object Payroll {
    val allEmployees = arrayListOf<Person>()

    fun calculateSalary() {
        for (person in allEmployees) {

        }
    }
}

class Person(val name: String)

object CaseInsensitiveFileComparator: java.util.Comparator<File> {
    override fun compare(file1: File, file2: File): Int {
        return file1.path.compareTo(file2.path, ignoreCase = true)
    }
}


data class Person2(val name: String) {
    object NameComparator: Comparator<Person2> {
        override fun compare(p1: Person2, p2: Person2): Int =
            p1.name.compareTo(p2.name)

    }
}

class A {
    companion object {
        fun bar() {
            println("Companion object called")
        }
    }
}

class User6 private constructor(val nickname: String) {
    companion object {
        fun newSubscribingUser(email:String) =
                User6(email.substringBefore("@"))

        fun newFacebookUser(accoutId: String) =
                User6(getFacebookName(accoutId))

        private fun getFacebookName(accoutId: String): String {

            return ""
        }
    }
}