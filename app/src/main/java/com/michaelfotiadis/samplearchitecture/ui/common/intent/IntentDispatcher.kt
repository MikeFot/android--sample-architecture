package com.michaelfotiadis.samplearchitecture.ui.common.intent

import android.app.Activity
import android.content.Intent

import com.michaelfotiadis.samplearchitecture.ui.main.MainActivity

class IntentDispatcher(private val activity: Activity) {

    fun startMainActiity() {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

}
