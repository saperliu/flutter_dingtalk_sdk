package com.liuyf.flutter_dingtalk_sdk.handlers

import android.util.Log
import com.android.dingtalk.share.ddsharemodule.ShareConstant
import com.android.dingtalk.share.ddsharemodule.message.BaseResp
import com.android.dingtalk.share.ddsharemodule.message.SendAuth
import io.flutter.plugin.common.MethodChannel
import java.util.*

object IDDShareResponseHandler {
    private var channel: MethodChannel? = null
    private const val errStr = "errStr"
    private const val errCode = "errCode"
    private const val mTransaction = "mTransaction"
    private const val type = "type"
    private const val code = "code"
    private const val state = "state"

    fun setMethodChannel(channel: MethodChannel) {
        IDDShareResponseHandler.channel = channel
    }
    fun handleResponse(baseResp: BaseResp) {
        val errCode = baseResp.mErrCode
        Log.d("lzc", "errorCode==========>$errCode")
        val errMsg = baseResp.mErrStr
        Log.d("lzc", "errMsg==========>$errMsg")
        if (baseResp.type == ShareConstant.COMMAND_SENDAUTH_V2 && baseResp is SendAuth.Resp) {//登陆
            handleAuthResponse(baseResp)
        } else {//分享
            handleSendMessageResp(baseResp)
        }

    }

    private fun handleAuthResponse(response: SendAuth.Resp) {
        val result = mapOf(
                errCode to response.mErrCode,
                errStr to response.mErrStr,
                code to response.code,
                state to response.state
        )
        channel?.invokeMethod("onAuthResponse", result)
    }

    private fun handleSendMessageResp(baseResp: BaseResp) {
        val result = mapOf(
                errCode to baseResp.mErrCode,
                errStr to baseResp.mErrStr,
                mTransaction to baseResp.mTransaction,
                type to baseResp.type
        )
        channel?.invokeMethod("onShareResponse", result)
    }
}