package com.example.vktoken

import android.content.Intent
import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import com.vk.sdk.util.VKUtil
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        // get package fingerprint
        Log.e("Fingerprints", VKUtil.getCertificateFingerprint(this, packageName).asString())

        btn_get_token.setOnClickListener { startActivity(Intent(this, WebViewActivity::class.java)) }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        // TODO: activity results
    }

    fun <T> Array<T>.asString() : String {
        return Arrays.toString(this);
    }
}