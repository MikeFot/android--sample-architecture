package com.michaelfotiadis.samplearchitecture.domain.listener

import com.michaelfotiadis.samplearchitecture.domain.model.LoadingState

interface LoadingCallbacks {

    fun onStateChanged(state: LoadingState)

}
