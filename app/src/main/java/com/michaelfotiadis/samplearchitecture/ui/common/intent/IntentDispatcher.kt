package com.michaelfotiadis.samplearchitecture.ui.common.intent

import android.app.Activity
import android.content.Intent
import com.michaelfotiadis.samplearchitecture.ui.chat.ChatActivity

import com.michaelfotiadis.samplearchitecture.ui.main.MainActivity
import com.michaelfotiadis.samplearchitecture.ui.posts.PostListActivity
import com.michaelfotiadis.samplearchitecture.ui.signup.SignUpActivity

class IntentDispatcher(private val activity: Activity) {

    fun startMainActiity() {
        activity.startActivity(Intent(activity, MainActivity::class.java))
    }

    fun startChatActiity() {
        activity.startActivity(Intent(activity, ChatActivity::class.java))
    }

    fun startSignUpActiity() {
        activity.startActivity(Intent(activity, SignUpActivity::class.java))
    }

    fun startPostsActiity() {
        activity.startActivity(Intent(activity, PostListActivity::class.java))
    }

}
