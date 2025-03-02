package com.falconeta.capacitor_tag_manager

import com.getcapacitor.JSObject
import com.getcapacitor.Logger
import com.getcapacitor.Plugin
import com.getcapacitor.PluginCall
import com.getcapacitor.PluginMethod
import com.getcapacitor.annotation.CapacitorPlugin


@CapacitorPlugin(
    name = "CapacitorTagManager",
)
class CapacitorTagManagerPlugin : Plugin() {

    private lateinit var implementation: CapacitorTagManager;

    override fun load() {
        super.load();
        implementation = CapacitorTagManager(context, bridge);
    }


    @PluginMethod
    fun getAppInstanceId(call: PluginCall) {
        try {
            implementation.getAppInstanceId(
                object : GetAppInstanceIdCallback {
                    override fun success(appInstanceId: String?) {
                        val result = JSObject()
                        if (appInstanceId != null) {
                            result.put("appInstanceId", appInstanceId)
                        }
                        call.resolve(result)
                    }

                    override fun error(message: String?) {
                        call.reject(message)
                    }
                }
            )
        } catch (exception: Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setConsent(call: PluginCall) {
        try {
            val consentType = FirebaseAnalyticsHelper.mapStringToConsentType(
                call.getString("type", null)
            )
            if (consentType == null) {
                call.reject(ERROR_CONSENT_TYPE_MISSING)
                return
            }
            val consentStatus = FirebaseAnalyticsHelper.mapStringToConsentStatus(
                call.getString("status", null)
            )
            if (consentStatus == null) {
                call.reject(ERROR_CONSENT_STATUS_MISSING)
                return
            }
            implementation.setConsent(consentType, consentStatus)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setUserId(call: PluginCall) {
        try {
            val userId = call.getString("userId", null)
            implementation.setUserId(userId)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setUserProperty(call: PluginCall) {
        try {
            val key = call.getString("key")
            if (key == null) {
                call.reject(ERROR_KEY_MISSING)
                return
            }
            val value = call.getString("value", null)
            implementation.setUserProperty(key, value)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setCurrentScreen(call: PluginCall) {
        try {
            val screenName = call.getString("screenName", null)
            val screenClassOverride = call.getString("screenClassOverride", null)
            implementation.setCurrentScreen(screenName, screenClassOverride)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun logEvent(call: PluginCall) {
        try {
            val name = call.getString("name")
            if (name == null) {
                call.reject(ERROR_NAME_MISSING)
                return
            }
            val params = call.getObject("params")
            implementation.logEvent(name, params)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setSessionTimeoutDuration(call: PluginCall) {
        try {
            val duration = call.getLong("duration", 1800000L)
            implementation.setSessionTimeoutDuration(duration!!)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun setEnabled(call: PluginCall) {
        try {
            val enabled = call.getBoolean("enabled")
            if (enabled == null) {
                call.reject(ERROR_ENABLED_MISSING)
                return
            }
            implementation.setEnabled(enabled)
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }

    @PluginMethod
    fun isEnabled(call: PluginCall) {
        call.unimplemented("Not implemented on Android.")
    }

    @PluginMethod
    fun resetAnalyticsData(call: PluginCall) {
        try {
            implementation.resetAnalyticsData()
            call.resolve()
        } catch (exception: java.lang.Exception) {
            Logger.error(TAG, exception.message, exception)
            call.reject(exception.message)
        }
    }
    companion object {
        const val TAG: String = "CapacitorTagManager"
        const val ERROR_KEY_MISSING: String = "key must be provided."
        const val ERROR_ENABLED_MISSING: String = "enabled must be provided."
        const val ERROR_NAME_MISSING: String = "name must be provided."
        const val ERROR_CONSENT_TYPE_MISSING: String = "consentType must be provided."
        const val ERROR_CONSENT_STATUS_MISSING: String = "consentStatus must be provided."
    }
}
