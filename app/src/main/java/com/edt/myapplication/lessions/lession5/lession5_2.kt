package com.edt.myapplication.lessions.lession5


/**
 * <pre>
 *     author : created by ljn
 *     e-mail : liujinan@edreamtree.com
 *     time   : 2019/4/2
 *     desc   :
 *     modify :
 * </pre>
 */
val list = listOf(Person("Alice", 29), Person("Bob", 31), Person("Canol", 31))
fun main() {
//    filter()
//    filterPerson()
//    map()
//    mapPersonName()
//    filterAndMap()
//    findMaxAge()
//    mapToMap()
//    checkAge()
//    groupBy()
    flatMap()
}

fun filter() {
    val list = listOf(1, 2, 3, 4)
    println(list.filter { it % 2 == 0 })
}

fun filterPerson() {
    println(list.filter { it.age > 30 })
}

fun map() {
    val list = listOf(1, 2, 3, 4)
    println(list.map { it * it })
}

fun mapPersonName() {
    println(list.map { it.name })
    println(list.map(Person::name))
}

fun filterAndMap() {
    println(list.filter { it.age > 30 }.map(Person::name))
}

fun findMaxAge() {
    //注意，此处会重复寻找最大年龄，如果没有必要，应该避免重复计算
    println(list.filter { it.age == list.maxBy(Person::age)?.age })
    val maxAge = list.maxBy(Person::age)!!.age
    println(list.filter { it.age == maxAge })
}

/**
 * filterKeys and mapKeys filter and map the keys
 * filterValues and mapValues filter and map the values
 */
fun mapToMap() {
    val map = mapOf(0 to "zaro", 1 to "one")
    println(map.mapValues { it.value.toUpperCase() })
    println(map.map { it.value.toUpperCase() })
}

fun  checkAge() {
    val canBeInClub27 = {p: Person -> p.age > 27}
    println(list.all(canBeInClub27))
    println(list.count(canBeInClub27))
}

fun groupBy() {
    println(list.groupBy { it.age })
}

fun flatMap() {
    val strings = listOf("abc", "def")
    println(strings.flatMap { it.toList() })
}

/**
 * 惰性集合操作：序列
 */
fun useSequence() {
    val toList = list.asSequence().map(Person::name).filter { it.startsWith("A") }.toList()
    println(toList)
}