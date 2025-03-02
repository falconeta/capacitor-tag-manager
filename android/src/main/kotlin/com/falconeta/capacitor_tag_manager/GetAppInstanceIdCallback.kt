package com.falconeta.capacitor_tag_manager

interface GetAppInstanceIdCallback {
    fun success(appInstanceId: String?)
    fun error(message: String?)
}