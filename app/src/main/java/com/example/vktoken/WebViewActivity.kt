package com.example.vktoken

import android.graphics.Bitmap
import android.net.Uri
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.webkit.WebView
import android.webkit.WebViewClient
import kotlinx.android.synthetic.main.activity_web_view.*

class WebViewActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_web_view)

        web_view.settings.setJavaScriptEnabled(true);
        web_view.setWebViewClient( object : WebViewClient() {
            override fun shouldOverrideUrlLoading(view: WebView, url: String): Boolean {
                view.loadUrl(url)
                return true
            }

            override fun onPageStarted(view: WebView?, url: String, favicon: Bitmap) {
                with(Uri.parse(url.replace("#", "?")).getQueryParameter("access_token")) {
                    if (this != null) {
                        Log.e("Token", this)
                    }
                }
            }
        })
        web_view.loadUrl("https://oauth.vk.com/authorize?client_id=5515242&redirect_uri=https://oauth.vk.com/blank.html&scope=notify,friends,offline,email,messages&response_type=token&v=5.52");
    }
}
