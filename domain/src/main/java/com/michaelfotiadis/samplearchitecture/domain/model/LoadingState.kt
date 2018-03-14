package com.michaelfotiadis.samplearchitecture.domain.model

enum class Status {
    RUNNING,
    SUCCESS,
    FAILED
}

@Suppress("DataClassPrivateConstructor")
data class LoadingState private constructor(
        val status: Status,
        val msg: String? = null,
        val exception: Throwable? = null) {
    companion object {
        val LOADED = LoadingState(Status.SUCCESS)
        val LOADING = LoadingState(Status.RUNNING)
        fun loaded(msg: String?) = LoadingState(Status.SUCCESS, msg = msg)
        fun error(msg: String?) = LoadingState(Status.FAILED, msg = msg)
        fun error(exception: Throwable?) = LoadingState(Status.FAILED, exception = exception)
    }
}