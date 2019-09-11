package com.edt.myapplication.lessions.lession8

interface OnCallback<T> {
    fun onSuccess(response: T)
    fun onFailed(message: String)
}

class OnCallbackImpl<T>(private val onSuccessF: (T) -> Unit, private val onErrorF: ((String) -> Unit)? = null): OnCallback<T> {
    override fun onSuccess(response: T) {
        onSuccessF(response)
    }

    override fun onFailed(message: String) {
        onErrorF?.let { it(message)}
    }

}

class OnCallbackImpl2<T>: OnCallback<T> {
    private lateinit var onSuccessF: (T) -> Unit
    private lateinit var onErrorF: (String) -> Unit

    fun onSuccess(listener:(T)->Unit) {
        this.onSuccessF = listener
    }
    override fun onSuccess(response: T) {
        this.onSuccessF(response)
    }

    fun onFailed(listener: (String) -> Unit) {
        this.onErrorF = listener
    }
    override fun onFailed(message: String) {
        this.onErrorF(message)
    }
}

fun main(args: Array<String>) {

}

class TestCallback {
    fun getData(callback: OnCallbackImpl<String>) {
        callback.onSuccess("很好的")
        callback.onFailed("")
    }

    fun getData(callback: OnCallbackImpl2<String>.() -> Unit) {
        val back = OnCallbackImpl2<String>()
        back.callback()
        back.onSuccess("很好的")
        back.onFailed("")
    }

    fun setData() {
        getData(OnCallbackImpl(onSuccessF = {
                //do success
            }, onErrorF = {
                //do error
            })
        )

        getData(OnCallbackImpl(onSuccessF = {
            //do success
        }))

        getData{
            onSuccess {

            }
            onFailed {

            }
        }

    }
}