package com.michaelfotiadis.samplearchitecture.domain.listener

abstract class Canceller {

    private var cancellable: Cancellable? = null

    fun register(cancellable: Cancellable) {
        this.cancellable = cancellable
    }

    fun unRegister() {
        this.cancellable = null
    }

    protected fun cancel() {
        if (cancellable != null) {
            cancellable!!.cancel()
        }
    }

}
