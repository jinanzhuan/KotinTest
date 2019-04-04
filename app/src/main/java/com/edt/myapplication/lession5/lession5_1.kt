package com.edt.myapplication.lession5


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/3/26
 *     desc   :
 *     modify :
 * </pre>
 */
fun main() {

    val people = listOf(Person("name1", 25))
    val room = Room(people)
    getOldestPerson(room.people)

}

data class Person(val name: String, val age: Int)

data class Room(val people: List<Person>)

fun findTheOldest(people: List<Person>) {
    var maxAge = 0
    var theOldest: Person? = null
    for (person in people) {
        if (person.age > maxAge) {
            maxAge = person.age
            theOldest = person
        }
    }
    println(theOldest)
}

val sum = {x: Int, y: Int -> x + y}

fun getSumData(x:Int, y: Int) {
    println(sum(x, y))
}

fun getMaxPerson(people: List<Person>) {
    //情形一 lambda作为实参
    people.maxBy({person: Person -> person.age })
    //Kotlin有这样的语法约定，如果lambda表达式是函数调用的最后一个实参，它可以放到括号的外边
    people.maxBy { person: Person -> person.age }
    //根据上下文可以推导出参数类型,可以进一步简化
    people.maxBy { person -> person.age }
    //进一步简化，可以用默认参数名称it代替命名参数
    people.maxBy { it.age }
    //当然也可以用成员引用代替
    people.maxBy(Person::age)

}

fun getOldestPerson(people: List<Person>) {

}