package com.michaelfotiadis.samplearchitecture.ui.main

import android.os.Bundle
import com.michaelfotiadis.samplearchitecture.R
import com.michaelfotiadis.samplearchitecture.ui.common.activity.BaseActivity
import com.michaelfotiadis.samplearchitecture.ui.common.intent.IntentDispatcher
import dagger.android.AndroidInjection
import javax.inject.Inject

class MainActivity : BaseActivity() {

    @Inject
    lateinit var dispatcher: IntentDispatcher

    override fun onCreate(savedInstanceState: Bundle?) {
        AndroidInjection.inject(this)
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
