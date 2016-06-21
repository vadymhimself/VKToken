package com.example.vktoken

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import com.vk.sdk.VKAccessToken
import com.vk.sdk.VKCallback
import com.vk.sdk.VKSdk
import com.vk.sdk.api.VKError
import com.vk.sdk.util.VKUtil
import kotlinx.android.synthetic.main.activity_main.*
import org.jetbrains.anko.startService
import java.util.*

class MainActivity : AppCompatActivity() {

    val proxyServer = ProxyServer()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get package fingerprint
        Log.e("Fingerprints", VKUtil.getCertificateFingerprint(this, packageName).asString())

        btn_get_token.setOnClickListener { VKSdk.login(this, "messages, notify, offline, friends, wall") }
        btn_test_proxy.setOnClickListener { proxyServer.test() }

        proxyServer.start()
    }

    override fun onDestroy() {
        super.onDestroy()
        proxyServer.stop()
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        rl_results.visibility = View.VISIBLE
        btn_get_token.visibility = View.GONE
        VKSdk.onActivityResult(requestCode, resultCode, data, object : VKCallback<VKAccessToken> {
            override fun onResult(res: VKAccessToken) {
                tv_token.text = res.accessToken
                tv_expires.text = res.expiresIn.toString()
                Log.e("Token", "accessToken: ${res.accessToken}, expiresIn: ${res.expiresIn}")
            }

            override fun onError(error: VKError) {
                tv_token.setTextColor(Color.RED)
                tv_token.text = error.errorMessage
            }
        })
    }

    fun <T> Array<T>.asString() : String {
        return Arrays.toString(this);
    }
}