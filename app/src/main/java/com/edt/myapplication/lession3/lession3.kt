package com.edt.myapplication.lession3

class User(val id: Int, val name: String, val address: String)

fun saveUser(user: User) {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can't save user ${user.id}"+"empty $fieldName") as Throwable
        }
    }
    validate(user.name, "Name")
    validate(user.address, "Address")
    //保存user到数据库
}

//扩展函数
fun User.validateBeforeSave() {
    fun validate(value: String, fieldName: String) {
        if (value.isEmpty()) {
            throw IllegalArgumentException("can't save user $id"+"empty $fieldName")
        }
    }
}

fun saveUser2(user: User) {
    user.validateBeforeSave()
}