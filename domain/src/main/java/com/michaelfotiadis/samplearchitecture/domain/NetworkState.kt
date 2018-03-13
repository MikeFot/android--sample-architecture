package com.michaelfotiadis.samplearchitecture.domain

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class NetworkState private constructor(
        val status: Status,
        val msg: String? = null,
        val exception: Throwable? = null) {
    companion object {
        val LOADED = NetworkState(Status.SUCCESS)
        val LOADING = NetworkState(Status.RUNNING)
        fun loaded(msg: String?) = NetworkState(Status.SUCCESS, msg = msg)
        fun error(msg: String?) = NetworkState(Status.FAILED, msg = msg)
        fun error(exception: Throwable?) = NetworkState(Status.FAILED, exception = exception)
    }
}