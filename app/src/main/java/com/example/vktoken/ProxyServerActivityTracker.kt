package com.example.vktoken

import android.util.Log
import io.netty.handler.codec.http.HttpRequest
import io.netty.handler.codec.http.HttpResponse
import org.littleshoot.proxy.ActivityTracker
import org.littleshoot.proxy.FlowContext
import org.littleshoot.proxy.FullFlowContext
import java.net.InetSocketAddress
import javax.net.ssl.SSLSession

/**
 * Created by Vadim Ovcharenko
 *            21.06.16.
 */

class ProxyServerActivityTracker : ActivityTracker {

    val TAG = this.javaClass.simpleName

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
}