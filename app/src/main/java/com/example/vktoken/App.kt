package com.example.vktoken

import android.app.Application
import com.vk.sdk.VKSdk

/**
 * Created by Vadim Ovcharenko
 *            20.06.16.
 */
class App : Application() {
    override fun onCreate() {
        VKSdk.initialize(this)
    }
}