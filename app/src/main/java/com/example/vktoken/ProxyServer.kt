package com.example.vktoken

import android.util.Log
import com.loopj.android.http.AsyncHttpClient
import com.loopj.android.http.AsyncHttpResponseHandler
import cz.msebera.android.httpclient.Header
import org.littleshoot.proxy.*
import org.littleshoot.proxy.impl.DefaultHttpProxyServer

/**
 * Created by Vadim Ovcharenko
 *            21.06.16.
 */
class ProxyServer(val serverBootstrap: HttpProxyServerBootstrap = DefaultHttpProxyServer.bootstrap()) {

    val TAG = this.javaClass.simpleName;

    lateinit var server : HttpProxyServer;

    init {
        serverBootstrap.withPort(8080).plusActivityTracker(ProxyServerActivityTracker())
    }

    fun start() {
        server = serverBootstrap.start()
    }

    fun stop() {
        server.stop()
    }

    fun test() {
        val client = AsyncHttpClient()
        client.setProxy("localhost", 8080)
        client.get("http://requestb.in/1dq6xbx1", object : AsyncHttpResponseHandler() {
            override fun onSuccess(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?) {
                Log.i(TAG, "onSuccess")
            }

            override fun onFailure(statusCode: Int, headers: Array<out Header>?, responseBody: ByteArray?, error: Throwable?) {
                Log.i(TAG, "onFailure")
            }
        })
    }
}