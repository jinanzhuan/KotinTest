package com.edt.myapplication.lession4


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
    Payroll.allEmployees.add(Persion("张三"))
    println(Payroll.allEmployees)
    Payroll.allEmployees.add(Persion("李四"))
    println(Payroll.allEmployees)
}

object Payroll {
    val allEmployees = arrayListOf<Persion>()

    fun calculateSalary() {
        for (persion in allEmployees) {

        }
    }
}

class Persion(val name: String)
