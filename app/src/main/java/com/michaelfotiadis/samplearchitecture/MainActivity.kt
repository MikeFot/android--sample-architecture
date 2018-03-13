package com.michaelfotiadis.samplearchitecture

import android.os.Bundle
import com.michaelfotiadis.samplearchitecture.common.activity.BaseChatActivity

class MainActivity : BaseChatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

}
