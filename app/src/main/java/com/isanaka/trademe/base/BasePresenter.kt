package com.isanaka.trademe.base

interface BasePresenter<T> {
    fun attachView(view: T)

    fun detachView()
}
