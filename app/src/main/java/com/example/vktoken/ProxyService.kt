package com.example.vktoken

import android.app.Service
import android.content.Intent
import android.os.IBinder
import android.util.Log
import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponse
import org.littleshoot.proxy.ActivityTracker
import org.littleshoot.proxy.FlowContext
import org.littleshoot.proxy.FullFlowContext

import org.littleshoot.proxy.HttpProxyServer
import org.littleshoot.proxy.impl.DefaultHttpProxyServer
import java.net.InetSocketAddress
import javax.net.ssl.SSLSession

class ProxyService : Service() {

    private val TAG = ProxyService::class.java.simpleName;
    private var server: HttpProxyServer? = null

    override fun onStartCommand(intent: Intent, flags: Int, startId: Int): Int {
        server = DefaultHttpProxyServer
                .bootstrap()
                .withPort(8080)
                .plusActivityTracker(object : ActivityTracker {
                    override fun requestSentToServer(flowContext: FullFlowContext?, httpRequest: HttpRequest?) {
                        Log.i(TAG, "requestSentToServer")
                    }

                    override fun clientDisconnected(clientAddress: InetSocketAddress?, sslSession: SSLSession?) {
                        Log.i(TAG, "clientDisconnected")
                    }

                    override fun responseSentToClient(flowContext: FlowContext?, httpResponse: HttpResponse?) {
                        Log.i(TAG, "responseSentToClient")
                    }

                    override fun clientConnected(clientAddress: InetSocketAddress?) {
                        Log.i(TAG, "clientConnected")
                    }

                    override fun requestReceivedFromClient(flowContext: FlowContext?, httpRequest: HttpRequest?) {
                        Log.i(TAG, "requestReceivedFromClient")
                    }

                    override fun clientSSLHandshakeSucceeded(clientAddress: InetSocketAddress?, sslSession: SSLSession?) {
                        Log.i(TAG, "clientSSLHandshakeSucceeded")
                    }

                    override fun bytesReceivedFromServer(flowContext: FullFlowContext?, numberOfBytes: Int) {
                        Log.i(TAG, "bytesReceivedFromServer")
                    }

                    override fun bytesSentToServer(flowContext: FullFlowContext?, numberOfBytes: Int) {
                        Log.i(TAG, "bytesSentToServer")
                    }

                    override fun responseReceivedFromServer(flowContext: FullFlowContext?, httpResponse: HttpResponse?) {
                        Log.i(TAG, "responseReceivedFromServer")
                    }

                    override fun bytesReceivedFromClient(flowContext: FlowContext?, numberOfBytes: Int) {
                        Log.i(TAG, "bytesReceivedFromClient")
                    }

                    override fun bytesSentToClient(flowContext: FlowContext?, numberOfBytes: Int) {
                        Log.i(TAG, "bytesSentToClient")
                    }
                })
                .start()
        return Service.START_STICKY
    }

    override fun onBind(intent: Intent): IBinder? {
        // TODO: Return the communication channel to the service.
        throw UnsupportedOperationException("Not yet implemented")
    }
}
